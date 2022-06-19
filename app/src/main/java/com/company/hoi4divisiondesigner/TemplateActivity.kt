package com.company.hoi4divisiondesigner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.company.hoi4divisiondesigner.databinding.ActivityTemplateBinding

class TemplateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemplateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var infInfCount = 0.0

        binding.infInfPlus.setOnClickListener{
            if (infInfCount < 25.0) {
                infInfCount++
                binding.infInfNum.text = "%.0f".format(infInfCount)
                calculate(infInfCount)
            }
        }
        binding.infInfMin.setOnClickListener{
            if (infInfCount != 0.0) {
                infInfCount--
                binding.infInfNum.text = "%.0f".format(infInfCount)
                calculate(infInfCount)
            }
        }
    }

    private fun calculate(infantryInfantry : Double) {

        val battalions = arrayOf(infantryInfantry, 0.0, 0.0)
        val speed = arrayOf(4.0, 0.0, 0.0)
        val hp = arrayOf(25.0, 0.0, 0.0)
        val organization = arrayOf(60.0, 0.0, 0.0)
        val recoveryRate = arrayOf(0.3, 0.0, 0.0)
        val suppression = arrayOf(1.5, 0.0, 0.0)
        val weight = arrayOf(0.5, 0.0, 0.0)
        val supplyUse = arrayOf(0.07, 0.0, 0.0)
        val softAttack = arrayOf(6.0, 0.0, 0.0)
        val hardAttack = arrayOf(1.0, 0.0, 0.0)
        val defence = arrayOf(23.1, 0.0, 0.0)
        val breakthrough = arrayOf(3.15, 0.0, 0.0)
        val combatWidth = arrayOf(2.0, 0.0, 0.0)
        val hardness = arrayOf(0.0, 0.0, 0.0)
        val piercings = arrayOf(4.0, 0.0, 0.0)

        var divMinSpeed = 0.0;
        for (item in battalions.indices){
            if (battalions[item] != 0.0){
                if (speed[item] > divMinSpeed) divMinSpeed = speed[item]
            }
        }
        binding.Speed.text = "%.1f".format(divMinSpeed)
        var hpDiv = arrayMultiply(battalions, hp)
        binding.HP.text = "%.0f".format(hpDiv)
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
        var softAttackDiv = arrayMultiply(battalions, softAttack)
        binding.softAttack.text = "%.1f".format(softAttackDiv)
        var hardAttackDiv = arrayMultiply(battalions, hardAttack)
        binding.hardAttack.text = "%.1f".format(hardAttackDiv)
        var defenceDiv = arrayMultiply(battalions, defence)
        binding.defense.text = "%.2f".format(defenceDiv)
        var breakthroughDiv = arrayMultiply(battalions, breakthrough)
        binding.breakthrough.text = "%.2f".format(breakthroughDiv)
        var combatWidthDiv = arrayMultiply(battalions, combatWidth)
        binding.combatWidth.text = "%.1f".format(combatWidthDiv)
        var hardnessDiv = weightedAverage(battalions, hardness)
        binding.hardness.text = "%.2f".format(hardnessDiv)

        var divMaxPiercing = 0.0
        for (item in battalions.indices){
            if (battalions[item] != 0.0){
                if (piercings[item] > divMaxPiercing) divMaxPiercing = piercings[item]
            }
        }
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
}