package com.company.hoi4divisiondesigner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.hoi4divisiondesigner.databinding.ActivityTemplateBinding

class TemplateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemplateBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val data = ArrayList<batData>()
    private val adapter = viewAdapter(this,data)

    var infInfCount = 0
    var infArtCount = 0
    var infAaCount = 0
    var infAtCount = 0
    var infRartCount = 0
    var infMountCount = 0
    var infParaCount = 0
    var infMarCount = 0
    var infBikeCount = 0
    var infPenCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView1.layoutManager = linearLayoutManager

        binding.myButton.setOnClickListener{
            showPopup(binding.myButton)
        }

        binding.recyclerView1.adapter = adapter
    }

    internal fun calculate() {
        if (itemIndex(data, "Infantry") != 500) {
            infInfCount = data[itemIndex(data, "Infantry")].batQuant
        }
        if (itemIndex(data, "Artillery") != 500) {
            infArtCount = data[itemIndex(data, "Artillery")].batQuant
        }
        if (itemIndex(data, "Anti-Air") != 500) {
            infAaCount = data[itemIndex(data, "Anti-Air")].batQuant
        }
        if (itemIndex(data, "Anti-Tank") != 500) {
            infAtCount = data[itemIndex(data, "Anti-Tank")].batQuant
        }
        if (itemIndex(data, "Rocket Artillery") != 500) {
            infRartCount = data[itemIndex(data, "Rocket Artillery")].batQuant
        }
        if (itemIndex(data, "Mountaineer") != 500) {
            infMountCount = data[itemIndex(data, "Mountaineer")].batQuant
        }
        if (itemIndex(data, "Paratrooper") != 500) {
            infParaCount = data[itemIndex(data, "Paratrooper")].batQuant
        }
        if (itemIndex(data, "Marine") != 500) {
            infMarCount = data[itemIndex(data, "Marine")].batQuant
        }
        if (itemIndex(data, "Bicycle") != 500) {
            infBikeCount = data[itemIndex(data, "Bicycle")].batQuant
        }
        if (itemIndex(data, "Penal Battalion") != 500) {
            infPenCount = data[itemIndex(data, "Penal Battalion")].batQuant
        }

        val battalions = arrayOf(infInfCount, infArtCount, infAaCount, infAtCount, infRartCount, infMountCount, infParaCount, infMarCount, infBikeCount, infPenCount)
        val speed = arrayOf(4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 6.4, 4.0)
        val hp = arrayOf(25.0, 0.6, 0.6, 0.6, 0.6, 20.0, 22.0, 20.0, 25.0, 15.0)
        val organization = arrayOf(60.0, 0.0, 0.0, 0.0, 0.0, 70.0, 70.0, 70.0, 60.0, 70.0)
        val recoveryRate = arrayOf(0.3, 0.1, 0.1, 0.0, 0.1, 0.4, 0.4, 0.4, 0.3, 0.4)
        val suppression = arrayOf(1.5, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 2.0, 0.5)
        val weight = arrayOf(0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5)
        val supplyUse = arrayOf(0.07, 0.2, 0.1, 0.1, 0.2, 0.07, 0.06, 0.06, 0.07, 0.05)
        val softAttack = arrayOf(6.0, 27.5, 3.0, 4.0, 30.0, 3.0, 3.0, 3.0, 3.0, 6.0)
        val hardAttack = arrayOf(1.0, 2.0, 7.0, 15.0, 1.0, 0.5, 0.5, 0.5, 0.5, 1.0)
        val airAttack = arrayOf(0.0, 0.0, 19.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
        val defence = arrayOf(22.0, 10.0, 4.0, 4.0, 12.0, 20.0, 20.0, 20.0, 20.0, 22.0)
        val breakthrough = arrayOf(3.15, 6.0, 1.0, 0.0, 9.0, 2.6, 2.0, 2.6, 2.0, 3.0)
        val combatWidth = arrayOf(2.0, 3.0, 1.0, 1.0, 3.0, 2.0, 2.0, 2.0, 2.0, 2.0)
        val hardness = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
        val piercings = arrayOf(4.0, 5.0, 25.0, 75.0, 2.0, 1.0, 1.0, 1.0, 1.0, 4.0)
        val manpower = arrayOf (1000.0, 500.0, 500.0, 500.0, 500.0, 1000.0, 1000.0, 1000.0, 1000.0, 850.0)
        val trainingTime = arrayOf(90.0, 120.0, 120.0, 120.0, 120.0, 120.0, 150.0, 120.0, 90.0, 50.0)
        val industryCost = arrayOf(43.0, 126.0, 120.0, 144.0, 144.0, 60.2, 55.9, 64.5, 83.0, 42.5)

        var divMinSpeed = minDiv(battalions, speed)
        binding.Speed.text = "%.1f".format(divMinSpeed)
        var hpDiv = arrayMultiply(battalions, hp)
        binding.HP.text = "%.1f".format(hpDiv)
        var organizationDiv = weightedAverage(battalions, organization)
        binding.Organization.text = "%.2f".format(organizationDiv)
        var recoveryRateDiv = weightedAverage(battalions, recoveryRate)
        binding.RecoveryRate.text = "%.2f".format(recoveryRateDiv)
        var suppressionDiv = arrayMultiply(battalions, suppression)
        binding.Suppression.text = "%.2f".format(suppressionDiv)
        var weightDiv = arrayMultiply(battalions, weight)
        binding.Weight.text = "%.1f".format(weightDiv)
        var supplyUseDiv = arrayMultiply(battalions, supplyUse)
        binding.SupplyUse.text = "%.2f".format(supplyUseDiv)
        var manpowerDiv = arrayMultiply(battalions, manpower)
        binding.Manpower.text = "%.0f".format(manpowerDiv)
        var trainingDiv = maxDiv(battalions, trainingTime)
        binding.Training.text = "%.0f".format(trainingDiv)
        var icDiv = arrayMultiply(battalions, industryCost)
        binding.Industry.text = "%.0f".format(icDiv)

        var softAttackDiv = arrayMultiply(battalions, softAttack)
        binding.softAttack.text = "%.1f".format(softAttackDiv)
        var hardAttackDiv = arrayMultiply(battalions, hardAttack)
        binding.hardAttack.text = "%.1f".format(hardAttackDiv)
        var airAttackDiv = arrayMultiply(battalions, airAttack)
        binding.airAttack.text = "%.1f".format(airAttackDiv)
        var defenceDiv = arrayMultiply(battalions, defence)
        binding.defense.text = "%.2f".format(defenceDiv)
        var breakthroughDiv = arrayMultiply(battalions, breakthrough)
        binding.breakthrough.text = "%.2f".format(breakthroughDiv)
        var combatWidthDiv = arrayMultiply(battalions, combatWidth)
        binding.combatWidth.text = "%.1f".format(combatWidthDiv)
        var hardnessDiv = weightedAverage(battalions, hardness)
        binding.hardness.text = "%.2f".format(hardnessDiv)

        var divMaxPiercing = maxDiv(battalions, piercings)
        var piercingDiv = 0.4 * divMaxPiercing + 0.6 * weightedAverage(battalions, piercings)
        binding.piercing.text = "%.2f".format(piercingDiv)
    }

    private fun weightedAverage (bats: Array<Int>, attr: Array<Double>) : Double{
        var total = 0.0
        for (item in bats.indices){
            total += bats[item] * attr[item]
        }
        return total / bats.sum()
    }

    private fun arrayMultiply (bats: Array<Int>, attr: Array<Double>) : Double {
        var total = 0.0
        for (item in bats.indices){
            total += bats[item] * attr[item]
        }
        return total
    }

    private fun maxDiv (bats: Array<Int>, attr: Array<Double>) : Double {
        var maxattr = 0.0
        for (item in bats.indices){
            if (bats[item] != 0){
                if (attr[item] > maxattr) maxattr = attr[item]
            }
        }
        return maxattr
    }

    private fun minDiv (bats: Array<Int>, attr: Array<Double>) : Double {
        var minattr = 100000.0
        for (item in bats.indices){
            if (bats[item] != 0){
                if (attr[item] < minattr) minattr = attr[item]
            }
        }
        if (minattr == 100000.0) return 0.0
        return minattr
    }

    private fun showPopup(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.header_menu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.header1 -> {
                    headers("Infantry", infInfCount)
                }
                R.id.header2 -> {
                    headers("Artillery", infArtCount)
                }
                R.id.header3 -> {
                    headers("Anti-Air", infAtCount)
                }
                R.id.header4 -> {
                    headers("Rocket Artillery", infRartCount)
                }
                R.id.header5 -> {
                    headers("Mountaineer", infMountCount)
                }
                R.id.header6 -> {
                    headers("Paratrooper", infParaCount)
                }
                R.id.header7 -> {
                    headers("Marine", infMarCount)
                }
                R.id.header8 -> {
                    headers("Bicycle", infBikeCount)
                }
                R.id.header9 -> {
                    headers("Penal Battalion", infPenCount)
                }
            }
            true
        })

        popup.show()
    }

    private fun headers (name : String, count : Int){
        if (data.isEmpty() || batExists(data,name) || count==0){
            data.add(batData(name, 1))
        }else if (count == 0 && itemIndex(data, name) != 500){
            data[itemIndex(data, name)].batQuant += 1
        }
        adapter.notifyDataSetChanged()
        calculate()
    }

    private fun batExists (data : ArrayList<batData>, bat : String) : Boolean{
        for (item in data){
            if (item.batName == bat) return false
        }
        return true
    }

    private fun itemIndex (data : ArrayList<batData>, bat : String) : Int{
        for (item in data.indices){
            if (data[item].batName == bat) return item
        }
        return 500
    }
}