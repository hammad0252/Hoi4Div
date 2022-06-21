package com.company.hoi4divisiondesigner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.company.hoi4divisiondesigner.databinding.ActivityTemplateBinding

class TemplateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemplateBinding

    var infInfCount = 0.0
    var infArtCount = 0.0
    var infAaCount = 0.0
    var infAtCount = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.infInfPlus.setOnClickListener{
            if (infInfCount < 25.0) {
                infInfCount++
                binding.infInfNum.text = "%.0f".format(infInfCount)
                calculate()
            }
        }
        binding.infInfMin.setOnClickListener{
            if (infInfCount != 0.0) {
                infInfCount--
                binding.infInfNum.text = "%.0f".format(infInfCount)
                calculate()
            }
        }

        binding.infArtPlus.setOnClickListener{
            if (infArtCount < 25.0) {
                infArtCount++
                binding.infArtNum.text = "%.0f".format(infArtCount)
                calculate()
            }
        }
        binding.infArtMin.setOnClickListener{
            if (infArtCount != 0.0) {
                infArtCount--
                binding.infArtNum.text = "%.0f".format(infArtCount)
                calculate()
            }
        }

        binding.infAaPlus.setOnClickListener{
            if (infAaCount < 25.0) {
                infAaCount++
                binding.infAaNum.text = "%.0f".format(infAaCount)
                calculate()
            }
        }
        binding.infAaMin.setOnClickListener{
            if (infAaCount != 0.0) {
                infAaCount--
                binding.infAaNum.text = "%.0f".format(infAaCount)
                calculate()
            }
        }

        binding.infAtPlus.setOnClickListener{
            if (infAtCount < 25.0) {
                infAtCount++
                binding.infAtNum.text = "%.0f".format(infAtCount)
                calculate()
            }
        }
        binding.infAtMin.setOnClickListener{
            if (infAtCount != 0.0) {
                infAtCount--
                binding.infAtNum.text = "%.0f".format(infAtCount)
                calculate()
            }
        }
    }

    private fun calculate() {

        val battalions = arrayOf(infInfCount, infArtCount, infAaCount, infAtCount)
        val speed = arrayOf(4.0, 4.0, 4.0, 4.0)
        val hp = arrayOf(25.0, 0.6, 0.6, 0.6)
        val organization = arrayOf(60.0, 0.0, 0.0, 0.0)
        val recoveryRate = arrayOf(0.3, 0.1, 0.1, 0.0)
        val suppression = arrayOf(1.5, 0.0, 0.0, 0.0)
        val weight = arrayOf(0.5, 0.5, 0.5, 0.5)
        val supplyUse = arrayOf(0.07, 0.2, 0.1, 0.1)
        val softAttack = arrayOf(6.0, 27.5, 3.0, 4.0)
        val hardAttack = arrayOf(1.0, 2.0, 7.0, 15.0)
        val airAttack = arrayOf(0.0, 0.0, 19.0, 0.0)
        val defence = arrayOf(23.1, 10.0, 4.0, 4.0)
        val breakthrough = arrayOf(3.15, 6.0, 1.0, 0.0)
        val combatWidth = arrayOf(2.0, 3.0, 1.0, 1.0)
        val hardness = arrayOf(0.0, 0.0, 0.0, 0.0)
        val piercings = arrayOf(4.0, 5.0, 25.0, 75.0)
        val manpower = arrayOf (1000.0, 500.0, 500.0, 500.0)
        val trainingTime = arrayOf(90.0, 120.0, 120.0, 120.0)
        val industryCost = arrayOf(43.0, 126.0, 120.0, 144.0)

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

    private fun weightedAverage (bats: Array<Double>, attr: Array<Double>) : Double{
        var total = 0.0
        for (item in bats.indices){
            total += bats[item] * attr[item]
        }
        return total / bats.sum()
    }

    private fun arrayMultiply (bats: Array<Double>, attr: Array<Double>) : Double {
        var total = 0.0
        for (item in bats.indices){
            total += bats[item] * attr[item]
        }
        return total
    }

    private fun maxDiv (bats: Array<Double>, attr: Array<Double>) : Double {
        var maxattr = 0.0
        for (item in bats.indices){
            if (bats[item] != 0.0){
                if (attr[item] > maxattr) maxattr = attr[item]
            }
        }
        return maxattr
    }

    private fun minDiv (bats: Array<Double>, attr: Array<Double>) : Double {
        var minattr = 100000.0
        for (item in bats.indices){
            if (bats[item] != 0.0){
                if (attr[item] < minattr) minattr = attr[item]
            }
        }
        return minattr
    }
}