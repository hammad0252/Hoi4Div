package com.company.hoi4divisiondesigner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.hoi4divisiondesigner.databinding.ActivityTemplateBinding
import com.google.android.material.snackbar.Snackbar

class TemplateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemplateBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val data = ArrayList<batData>()
    private val adapter = viewAdapter(this,data)
    private var techYear = 1936

    private var infInfCount = 0
    private var infArtCount = 0
    private var infAaCount = 0
    private var infAtCount = 0
    private var infRartCount = 0
    private var infMountCount = 0
    private var infParaCount = 0
    private var infMarCount = 0
    private var infBikeCount = 0

    private var motInfCount = 0
    private var motArtCount = 0
    private var motAaCount = 0
    private var motAtCount = 0
    private var motRartCount = 0
    private var motCavCount = 0
    private var motCamCount = 0
    private var mechInfCount = 0
    private var amtracCount = 0
    private var armCarCount = 0

    private var lightTankCount = 0
    private var mediumTankCount = 0
    private var heavyTankCount = 0
    private var superHeavyTankCount = 0
    private var modernTankCount = 0

    private var speed = mutableListOf<Double>()
    private var hp = mutableListOf<Double>()
    private var organization = mutableListOf<Double>()
    private var recoveryRate = mutableListOf<Double>()
    private var suppression = mutableListOf<Double>()
    private var weight = mutableListOf<Double>()
    private var supplyUse = mutableListOf<Double>()
    private var fuelUse = mutableListOf<Double>()
    private var fuelCap = mutableListOf<Double>()
    private var manpower = mutableListOf<Double>()
    private var trainingTime = mutableListOf<Double>()
    private var industryCost = mutableListOf<Double>()
    private var softAttack = mutableListOf<Double>()
    private var hardAttack = mutableListOf<Double>()
    private var airAttack = mutableListOf<Double>()
    private var defence = mutableListOf<Double>()
    private var breakthrough = mutableListOf<Double>()
    private var armour = mutableListOf<Double>()
    private var piercings = mutableListOf<Double>()
    private var combatWidth = mutableListOf<Double>()
    private var hardness = mutableListOf<Double>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView1.layoutManager = linearLayoutManager

        binding.infBatButton.setOnClickListener{
            addInfBat(binding.infBatButton)
        }

        binding.motBatButton.setOnClickListener{
            addMotBat(binding.motBatButton)
        }

        binding.armBatButton.setOnClickListener{
            addArmBat(binding.armBatButton)
        }

        binding.techYear.text = techYear.toString()
        binding.techYear.setOnClickListener{
            techYear(binding.techYear)
        }

        binding.recyclerView1.adapter = adapter

        binding.supportAA.setOnClickListener{
            calculate()
        }
        binding.supportAT.setOnClickListener{
            calculate()
        }
        binding.supportArt.setOnClickListener{
            calculate()
        }
        binding.supportRart.setOnClickListener{
            calculate()
        }
        binding.supportEng.setOnClickListener{
            calculate()
        }
        binding.supportFieldhosp.setOnClickListener{
            calculate()
        }
        binding.supportLogistics.setOnClickListener{
            calculate()
        }
        binding.supportMaintenance.setOnClickListener{
            calculate()
        }
        binding.supportMilitaryPolice.setOnClickListener{
            calculate()
        }
        binding.supportReconCav.setOnClickListener{
            calculate()
        }
        binding.supportReconMot.setOnClickListener{
            calculate()
        }
        binding.supportReconLightarmour.setOnClickListener{
            calculate()
        }
        binding.supportReconArmoured.setOnClickListener{
            calculate()
        }
        binding.supportSignal.setOnClickListener{
            calculate()
        }
    }

    internal fun calculate() {
        val battalionsData = battalion.battalionData(techYear)

        speed = mutableListOf<Double>()
        hp = mutableListOf<Double>()
        organization = mutableListOf<Double>()
        recoveryRate = mutableListOf<Double>()
        suppression = mutableListOf<Double>()
        weight = mutableListOf<Double>()
        supplyUse = mutableListOf<Double>()
        fuelUse = mutableListOf<Double>()
        fuelCap = mutableListOf<Double>()
        manpower = mutableListOf<Double>()
        trainingTime = mutableListOf<Double>()
        industryCost = mutableListOf<Double>()
        softAttack = mutableListOf<Double>()
        hardAttack = mutableListOf<Double>()
        airAttack = mutableListOf<Double>()
        defence = mutableListOf<Double>()
        breakthrough = mutableListOf<Double>()
        armour = mutableListOf<Double>()
        piercings = mutableListOf<Double>()
        combatWidth = mutableListOf<Double>()
        hardness = mutableListOf<Double>()

        for (items in battalionsData) {
            speed.add(items.speed)
        }
        for (items in battalionsData) {
            hp.add(items.hp)
        }
        for (items in battalionsData) {
            organization.add(items.organization)
        }
        for (items in battalionsData) {
            recoveryRate.add(items.recoveryRate)
        }
        for (items in battalionsData) {
            suppression.add(items.suppression)
        }
        for (items in battalionsData) {
            weight.add(items.weight)
        }
        for (items in battalionsData) {
            supplyUse.add(items.supplyUse)
        }
        for (items in battalionsData) {
            fuelUse.add(items.fuelUse)
        }
        for (items in battalionsData) {
            fuelCap.add(items.fuelCap)
        }
        for (items in battalionsData) {
            manpower.add(items.manpower)
        }
        for (items in battalionsData) {
            trainingTime.add(items.trainingTime)
        }
        for (items in battalionsData) {
            industryCost.add(items.industryCost)
        }
        for (items in battalionsData) {
            softAttack.add(items.softAttack)
        }
        for (items in battalionsData) {
            hardAttack.add(items.hardAttack)
        }
        for (items in battalionsData) {
            airAttack.add(items.airAttack)
        }
        for (items in battalionsData) {
            defence.add(items.defence)
        }
        for (items in battalionsData) {
            breakthrough.add(items.breakthrough)
        }
        for (items in battalionsData) {
            armour.add(items.armour)
        }
        for (items in battalionsData) {
            piercings.add(items.piercing)
        }
        for (items in battalionsData) {
            combatWidth.add(items.combatWidth)
        }
        for (items in battalionsData) {
            hardness.add(items.hardness)
        }

        infInfCount = if (itemIndex(data, getString(R.string.infantry)) != 500) {
            data[itemIndex(data, getString(R.string.infantry))].batQuant
        } else 0
        infArtCount = if (itemIndex(data, getString(R.string.artillery)) != 500) {
            data[itemIndex(data, getString(R.string.artillery))].batQuant
        } else 0
        infAaCount = if (itemIndex(data, getString(R.string.anti_air)) != 500) {
            data[itemIndex(data, getString(R.string.anti_air))].batQuant
        } else 0
        infAtCount = if (itemIndex(data, getString(R.string.anti_tank)) != 500) {
            data[itemIndex(data, getString(R.string.anti_tank))].batQuant
        } else 0
        infRartCount = if (itemIndex(data, getString(R.string.rocket_artillery)) != 500) {
            data[itemIndex(data, getString(R.string.rocket_artillery))].batQuant
        } else 0
        infMountCount = if (itemIndex(data, getString(R.string.mountaineer)) != 500) {
            data[itemIndex(data, getString(R.string.mountaineer))].batQuant
        } else 0
        infParaCount = if (itemIndex(data, getString(R.string.paratrooper)) != 500) {
            data[itemIndex(data, getString(R.string.paratrooper))].batQuant
        } else 0
        infMarCount = if (itemIndex(data, getString(R.string.marine)) != 500) {
            data[itemIndex(data, getString(R.string.marine))].batQuant
        } else 0
        infBikeCount = if (itemIndex(data, getString(R.string.bicycle)) != 500) {
            data[itemIndex(data, getString(R.string.bicycle))].batQuant
        } else 0
        motInfCount = if (itemIndex(data, getString(R.string.motorized_infantry)) != 500) {
            data[itemIndex(data, getString(R.string.motorized_infantry))].batQuant
        } else 0
        motArtCount = if (itemIndex(data, getString(R.string.motorized_artillery)) != 500) {
            data[itemIndex(data, getString(R.string.motorized_artillery))].batQuant
        } else 0
        motAaCount = if (itemIndex(data, getString(R.string.motorized_anti_air)) != 500) {
            data[itemIndex(data, getString(R.string.motorized_anti_air))].batQuant
        } else 0
        motAtCount = if (itemIndex(data, getString(R.string.motorized_anti_tank)) != 500) {
            data[itemIndex(data, getString(R.string.motorized_anti_tank))].batQuant
        } else 0
        motRartCount = if (itemIndex(data, getString(R.string.motorized_rocket_artillery)) != 500) {
            data[itemIndex(data, getString(R.string.motorized_rocket_artillery))].batQuant
        } else 0
        motCavCount = if (itemIndex(data, getString(R.string.cavalry)) != 500) {
            data[itemIndex(data, getString(R.string.cavalry))].batQuant
        } else 0
        motCamCount = if (itemIndex(data, getString(R.string.camel)) != 500) {
            data[itemIndex(data, getString(R.string.camel))].batQuant
        } else 0
        mechInfCount = if (itemIndex(data, getString(R.string.mechanized_infantry)) != 500) {
            data[itemIndex(data, getString(R.string.mechanized_infantry))].batQuant
        } else 0
        amtracCount = if (itemIndex(data, getString(R.string.amtrac_battalion)) != 500) {
            data[itemIndex(data, getString(R.string.amtrac_battalion))].batQuant
        } else 0
        armCarCount = if (itemIndex(data, getString(R.string.armoured_car)) != 500) {
            data[itemIndex(data, getString(R.string.armoured_car))].batQuant
        } else 0
        lightTankCount = if (itemIndex(data, getString(R.string.light_tank)) != 500) {
            data[itemIndex(data, getString(R.string.light_tank))].batQuant
        } else 0
        mediumTankCount = if (itemIndex(data, getString(R.string.medium_tank)) != 500) {
            data[itemIndex(data, getString(R.string.medium_tank))].batQuant
        } else 0
        heavyTankCount = if (itemIndex(data, getString(R.string.heavy_tank)) != 500) {
            data[itemIndex(data, getString(R.string.heavy_tank))].batQuant
        } else 0
        superHeavyTankCount = if (itemIndex(data, getString(R.string.super_heavy_tank)) != 500) {
            data[itemIndex(data, getString(R.string.super_heavy_tank))].batQuant
        } else 0
        modernTankCount = if (itemIndex(data, getString(R.string.modern_tank)) != 500) {
            data[itemIndex(data, getString(R.string.modern_tank))].batQuant
        } else 0

        val battalions = arrayOf(infInfCount, infArtCount, infAaCount, infAtCount, infRartCount, infMountCount, infParaCount, infMarCount, infBikeCount,
                                motInfCount, motArtCount, motAaCount, motAtCount, motRartCount, motCavCount, motCamCount, mechInfCount, amtracCount, armCarCount,
                                lightTankCount, mediumTankCount, heavyTankCount, superHeavyTankCount, modernTankCount)

        var divMinSpeed = minDiv(battalions, speed)
        var hpDiv = arrayMultiply(battalions, hp)
        var organizationDiv = weightedAverage(battalions, organization)
        var recoveryRateDiv = weightedAverage(battalions, recoveryRate)
        val suppressionDiv = arrayMultiply(battalions, suppression)
        var weightDiv = arrayMultiply(battalions, weight)
        var supplyUseDiv = arrayMultiply(battalions, supplyUse)
        var fuelUseDiv = arrayMultiply(battalions, fuelUse)
        var fuelCapDiv = arrayMultiply(battalions, fuelCap)
        var manpowerDiv = arrayMultiply(battalions, manpower)
        var trainingDiv = maxDiv(battalions, trainingTime)
        var icDiv: Double = arrayMultiply(battalions, industryCost)

        var softAttackDiv = arrayMultiply(battalions, softAttack)
        var hardAttackDiv = arrayMultiply(battalions, hardAttack)
        var airAttackDiv = arrayMultiply(battalions, airAttack)
        var defenceDiv = arrayMultiply(battalions, defence)
        var breakthroughDiv = arrayMultiply(battalions, breakthrough)
        val combatWidthDiv = arrayMultiply(battalions, combatWidth)
        val hardnessDiv = weightedAverage(battalions, hardness)
        var divMaxArmour = maxDiv(battalions, armour)
        var armourDiv = 0.3 * divMaxArmour + 0.7 * weightedAverage(battalions, armour)
        var divMaxPiercing = maxDiv(battalions, piercings)
        var piercingDiv = 0.4 * divMaxPiercing + 0.6 * weightedAverage(battalions, piercings)

        var supportDivs = 0
        var batpierce: Double
        var batarmour: Double
        if (binding.supportAA.isChecked){
            hpDiv += 0.2
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.1) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.1
            manpowerDiv += 300
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 80.0

            softAttackDiv += 1.8
            hardAttackDiv += 4.2
            airAttackDiv += 15.2
            defenceDiv += 2.4
            breakthroughDiv += 0.6
            batpierce = 25.0
            if (divMaxPiercing < batpierce) divMaxPiercing = batpierce
            piercingDiv = 0.4 * divMaxPiercing + 0.6 * ((piercingDiv * (totalDivs(battalions) + supportDivs) + batpierce) / (totalDivs(battalions) + supportDivs + 1))

            organizationDiv = organizationDiv * (totalDivs(battalions) + supportDivs) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportAT.isChecked){
            hpDiv += 0.2
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.1) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.08
            manpowerDiv += 300
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 96.0

            softAttackDiv += 2.0
            hardAttackDiv += 7.5
            defenceDiv += 2.0
            batpierce = 63.75
            if (divMaxPiercing < batpierce) divMaxPiercing = batpierce
            piercingDiv = 0.4 * divMaxPiercing + 0.6 * ((piercingDiv * (totalDivs(battalions) + supportDivs) + batpierce) / (totalDivs(battalions) + supportDivs + 1))

            organizationDiv = organizationDiv * (totalDivs(battalions) + supportDivs) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportArt.isChecked){
            hpDiv += 0.2
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.1) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.16
            manpowerDiv += 300
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 42.0

            softAttackDiv += 17.5
            hardAttackDiv += 1.2
            defenceDiv += 6.0
            breakthroughDiv += 3.6
            batpierce = 5.0
            if (divMaxPiercing < batpierce) divMaxPiercing = batpierce
            piercingDiv = 0.4 * divMaxPiercing + 0.6 * ((piercingDiv * (totalDivs(battalions) + supportDivs) + batpierce) / (totalDivs(battalions) + supportDivs + 1))

            organizationDiv = organizationDiv * (totalDivs(battalions) + supportDivs) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportRart.isChecked){
            hpDiv += 0.2
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.1) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.16
            manpowerDiv += 300
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 48.0

            softAttackDiv += 15.0
            hardAttackDiv += 0.5
            defenceDiv += 6.0
            breakthroughDiv += 4.5
            batpierce = 2.0
            if (divMaxPiercing < batpierce) divMaxPiercing = batpierce
            piercingDiv = 0.4 * divMaxPiercing + 0.6 * ((piercingDiv * (totalDivs(battalions) + supportDivs) + batpierce) / (totalDivs(battalions) + supportDivs + 1))

            organizationDiv = organizationDiv * (totalDivs(battalions) + supportDivs) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportEng.isChecked){
            hpDiv += 2
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.3) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.02
            manpowerDiv += 300
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 125.0

            softAttackDiv += 3.0
            hardAttackDiv += 1.0
            defenceDiv += 24.2
            breakthroughDiv += 4.5
            batpierce = 4.0
            if (divMaxPiercing < batpierce) divMaxPiercing = batpierce
            piercingDiv = 0.4 * divMaxPiercing + 0.6 * ((piercingDiv * (totalDivs(battalions) + supportDivs) + batpierce) / (totalDivs(battalions) + supportDivs + 1))

            organizationDiv = (organizationDiv * (totalDivs(battalions) + supportDivs) + 20.0) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportFieldhosp.isChecked){
            hpDiv += 2
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.3) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.05
            manpowerDiv += 500
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 170.0

            organizationDiv = (organizationDiv * (totalDivs(battalions) + supportDivs) + 20.0) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportLogistics.isChecked){
            hpDiv += 1
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.3) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            manpowerDiv += 500
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 105.0
            supplyUseDiv *= 0.90

            organizationDiv = (organizationDiv * (totalDivs(battalions) + supportDivs) + 10.0) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportMaintenance.isChecked){
            hpDiv += 1
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.3) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.03
            manpowerDiv += 500
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 100.0

            organizationDiv = (organizationDiv * (totalDivs(battalions) + supportDivs) + 20.0) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportMilitaryPolice.isChecked){
            hpDiv += 1
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.3) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.02
            manpowerDiv += 500
            if (trainingDiv < 180) trainingDiv = 180.0
            icDiv += 60.0

            softAttackDiv += 6.0
            hardAttackDiv += 1.0
            defenceDiv += 22.0
            breakthroughDiv += 3.0
            batpierce = 4.0
            if (divMaxPiercing < batpierce) divMaxPiercing = batpierce
            piercingDiv = 0.4 * divMaxPiercing + 0.6 * ((piercingDiv * (totalDivs(battalions) + supportDivs) + batpierce) / (totalDivs(battalions) + supportDivs + 1))

            organizationDiv = (organizationDiv * (totalDivs(battalions) + supportDivs) + 20.0) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportReconCav.isChecked){
            if (divMinSpeed > 6.4) divMinSpeed = 6.4
            hpDiv += 2
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.3) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.02
            manpowerDiv += 500
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 60.0

            softAttackDiv += 0.6
            hardAttackDiv += 0.1
            defenceDiv += 11.0
            breakthroughDiv += 1.5
            batpierce = 4.0
            if (divMaxPiercing < batpierce) divMaxPiercing = batpierce
            piercingDiv = 0.4 * divMaxPiercing + 0.6 * ((piercingDiv * (totalDivs(battalions) + supportDivs) + batpierce) / (totalDivs(battalions) + supportDivs + 1))

            organizationDiv = (organizationDiv * (totalDivs(battalions) + supportDivs) + 20.0) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportReconMot.isChecked){
            if (divMinSpeed > 12.0) divMinSpeed = 12.0
            hpDiv += 2
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.3) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.02
            fuelUseDiv += 1.2
            fuelCapDiv += 34.56
            manpowerDiv += 500
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 110.0

            softAttackDiv += 0.6
            hardAttackDiv += 0.1
            defenceDiv += 20.02
            breakthroughDiv += 1.5
            batpierce = 4.0
            if (divMaxPiercing < batpierce) divMaxPiercing = batpierce
            piercingDiv = 0.4 * divMaxPiercing + 0.6 * ((piercingDiv * (totalDivs(battalions) + supportDivs) + batpierce) / (totalDivs(battalions) + supportDivs + 1))

            organizationDiv = (organizationDiv * (totalDivs(battalions) + supportDivs) + 20.0) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportReconLightarmour.isChecked){
            if (divMinSpeed > 9.0) divMinSpeed = 9.0
            hpDiv += 2
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.3) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.02
            fuelUseDiv += 0.8
            fuelCapDiv += 23.04
            manpowerDiv += 500
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 96.0

            softAttackDiv += 0.6
            hardAttackDiv += 0.1
            defenceDiv += 1.0
            breakthroughDiv += 6.0
            batarmour = 3.0
            if (divMaxArmour < batarmour) divMaxArmour = batarmour
            armourDiv = 0.3 * divMaxArmour + 0.7 * ((armourDiv * (totalDivs(battalions) + supportDivs) + batarmour) / (totalDivs(battalions) + supportDivs + 1))
            batpierce = 6.0
            if (divMaxPiercing < batpierce) divMaxPiercing = batpierce
            piercingDiv = 0.4 * divMaxPiercing + 0.6 * ((piercingDiv * (totalDivs(battalions) + supportDivs) + batpierce) / (totalDivs(battalions) + supportDivs + 1))

            organizationDiv = (organizationDiv * (totalDivs(battalions) + supportDivs) + 20.0) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportReconArmoured.isChecked){
            if (divMinSpeed > 12.0) divMinSpeed = 12.0
            hpDiv += 2
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.3) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.02
            fuelUseDiv += 2.4
            fuelCapDiv += 69.12
            manpowerDiv += 500
            if (trainingDiv < 120) trainingDiv = 120.0
            icDiv += 216.0

            softAttackDiv += 1.6
            hardAttackDiv += 0.6
            defenceDiv += 2.5
            breakthroughDiv += 18.0
            batarmour = 15.0
            if (divMaxArmour < batarmour) divMaxArmour = batarmour
            armourDiv = 0.3 * divMaxArmour + 0.7 * ((armourDiv * (totalDivs(battalions) + supportDivs) + batarmour) / (totalDivs(battalions) + supportDivs + 1))
            batpierce = 30.0
            if (divMaxPiercing < batpierce) divMaxPiercing = batpierce
            piercingDiv = 0.4 * divMaxPiercing + 0.6 * ((piercingDiv * (totalDivs(battalions) + supportDivs) + batpierce) / (totalDivs(battalions) + supportDivs + 1))

            organizationDiv = (organizationDiv * (totalDivs(battalions) + supportDivs) + 20.0) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        if (binding.supportSignal.isChecked){
            hpDiv += 1
            recoveryRateDiv = (recoveryRateDiv * (totalDivs(battalions) + supportDivs) + 0.3) / (totalDivs(battalions) + supportDivs + 1)
            weightDiv += 0.1
            supplyUseDiv += 0.02
            manpowerDiv += 500
            if (trainingDiv < 180) trainingDiv = 180.0
            icDiv += 105.0

            organizationDiv = (organizationDiv * (totalDivs(battalions) + supportDivs) + 20.0) / (totalDivs(battalions) + supportDivs + 1)
            supportDivs += 1
        }

        binding.Speed.text = "%.1f".format(divMinSpeed)
        binding.HP.text = "%.1f".format(hpDiv)
        binding.Organization.text = "%.2f".format(organizationDiv)
        binding.RecoveryRate.text = "%.2f".format(recoveryRateDiv)
        binding.Suppression.text = "%.2f".format(suppressionDiv)
        binding.Weight.text = "%.1f".format(weightDiv)
        binding.SupplyUse.text = "%.2f".format(supplyUseDiv)
        binding.fuelUse.text = "%.2f".format(fuelUseDiv)
        binding.fuelCap.text = "%.2f".format(fuelCapDiv)
        binding.Manpower.text = "%.0f".format(manpowerDiv)
        binding.Training.text = "%.0f".format(trainingDiv)
        binding.Industry.text = "%.0f".format(icDiv)
        binding.softAttack.text = "%.1f".format(softAttackDiv)
        binding.hardAttack.text = "%.1f".format(hardAttackDiv)
        binding.airAttack.text = "%.1f".format(airAttackDiv)
        binding.defense.text = "%.2f".format(defenceDiv)
        binding.breakthrough.text = "%.2f".format(breakthroughDiv)
        binding.combatWidth.text = "%.1f".format(combatWidthDiv)
        binding.hardness.text = "%.2f".format(hardnessDiv)
        binding.piercing.text = "%.2f".format(piercingDiv)
        binding.armour.text = "%.2f".format(armourDiv)
    }

    private fun weightedAverage (bats: Array<Int>, attr: MutableList<Double>) : Double{
        var total = 0.0
        for (item in bats.indices){
            total += bats[item] * attr[item]
        }
        return total / bats.sum()
    }

    private fun totalDivs (bats: Array<Int>) : Int{
        var total = 0
        for (item in bats.indices){
            total += bats[item]
        }
        return total
    }

    private fun arrayMultiply (bats: Array<Int>, attr: MutableList<Double>) : Double {
        var total = 0.0
        for (item in bats.indices){
            total += bats[item] * attr[item]
        }
        return total
    }

    private fun maxDiv (bats: Array<Int>, attr: MutableList<Double>) : Double {
        var maxattr = 0.0
        for (item in bats.indices){
            if (bats[item] != 0){
                if (attr[item] > maxattr) maxattr = attr[item]
            }
        }
        return maxattr
    }

    private fun minDiv (bats: Array<Int>, attr: MutableList<Double>) : Double{
        var minattr = 100000.0
        for (item in bats.indices){
            if (bats[item] != 0){
                if (attr[item] < minattr) minattr = attr[item]
            }
        }
        if (minattr == 100000.0) return 0.0
        return minattr
    }

    private fun addInfBat(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.infantry_battalion_menu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.header1 -> {
                    headers(getString(R.string.infantry), infInfCount)
                }
                R.id.header2 -> {
                    headers(getString(R.string.artillery), infArtCount)
                }
                R.id.header3 -> {
                    headers(getString(R.string.anti_air), infAaCount)
                }
                R.id.header4 -> {
                    headers(getString(R.string.anti_tank), infAtCount)
                }
                R.id.header5 -> {
                    if (techYear > 1939) {
                        headers(getString(R.string.rocket_artillery), infRartCount)
                    } else {
                        Snackbar.make(view, "Rocket Artillery is not available before 1940", Snackbar.LENGTH_LONG).show()
                    }
                }
                R.id.header6 -> {
                    headers(getString(R.string.mountaineer), infMountCount)
                }
                R.id.header7 -> {
                    headers(getString(R.string.paratrooper), infParaCount)
                }
                R.id.header8 -> {
                    headers(getString(R.string.marine), infMarCount)
                }
                R.id.header9 -> {
                    headers(getString(R.string.bicycle), infBikeCount)
                }
            }
            true
        })
        popup.show()
    }

    private fun addMotBat(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.motorized_battalion_menu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.header1 -> {
                    headers(getString(R.string.motorized_infantry), motInfCount)
                }
                R.id.header2 -> {
                    headers(getString(R.string.motorized_artillery), motArtCount)
                }
                R.id.header3 -> {
                    headers(getString(R.string.motorized_anti_air), motAaCount)
                }
                R.id.header4 -> {
                    headers(getString(R.string.motorized_anti_tank), motAtCount)
                }
                R.id.header5 -> {
                    if (techYear > 1938) {
                        headers(getString(R.string.motorized_rocket_artillery), motRartCount)
                } else {
                        Snackbar.make(
                            view,
                            "Motorized Rocket Artillery is not available before 1939",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
                R.id.header6 -> {
                    headers(getString(R.string.cavalry), motCavCount)
                }
                R.id.header7 -> {
                    headers(getString(R.string.camel), motCamCount)
                }
                R.id.header8 -> {
                    if (techYear > 1939) {
                        headers(getString(R.string.mechanized_infantry), mechInfCount)
                    } else {
                        Snackbar.make(
                            view,
                            "Mechanized Infantry is not available before 1940",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
                R.id.header9 -> {
                    if (techYear > 1940) {
                        headers(getString(R.string.amtrac_battalion), amtracCount)
                    } else {
                        Snackbar.make(
                            view,
                            "AMTRAC Battalion is not available before 1941",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
                R.id.header10 -> {
                    headers(getString(R.string.armoured_car), armCarCount)
                }
            }
            true
        })
        popup.show()
    }

    private fun addArmBat(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.armoured_battalion_menu)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.header1 -> {
                    headers(getString(R.string.light_tank), lightTankCount)
                }
                R.id.header2 -> {
                    if (techYear > 1938) {
                        headers(getString(R.string.medium_tank), mediumTankCount)
                    } else {
                        Snackbar.make(
                            view,
                            "Medium Tank is not available before 1939",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
                R.id.header3 -> {
                    headers(getString(R.string.heavy_tank), heavyTankCount)
                }
                R.id.header4 -> {
                    if (techYear > 1942) {
                        headers(getString(R.string.super_heavy_tank), superHeavyTankCount)
                    } else {
                        Snackbar.make(
                            view,
                            "Super Heavy Tank is not available before 1943",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
                R.id.header5 -> {
                    if (techYear > 1944) {
                        headers(getString(R.string.modern_tank), modernTankCount)
                    } else {
                        Snackbar.make(
                            view,
                            "Modern Tank is not available before 1945",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
            }
            true
        })
        popup.show()
    }

    private fun techYear(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.tech_year_layout)
        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.header1 -> {
                    techYear = 1936
                    binding.techYear.text = techYear.toString()
                }
                R.id.header2 -> {
                    techYear = 1937
                    binding.techYear.text = techYear.toString()
                }
                R.id.header3 -> {
                    techYear = 1938
                    binding.techYear.text = techYear.toString()
                }
                R.id.header4 -> {
                    techYear = 1939
                    binding.techYear.text = techYear.toString()
                }
                R.id.header5 -> {
                    techYear = 1940
                    binding.techYear.text = techYear.toString()
                }
                R.id.header6 -> {
                    techYear = 1941
                    binding.techYear.text = techYear.toString()
                }
                R.id.header7 -> {
                    techYear = 1942
                    binding.techYear.text = techYear.toString()
                }
                R.id.header8 -> {
                    techYear = 1943
                    binding.techYear.text = techYear.toString()
                }
                R.id.header9 -> {
                    techYear = 1944
                    binding.techYear.text = techYear.toString()
                }
                R.id.header10 -> {
                    techYear = 1945
                    binding.techYear.text = techYear.toString()
                }
            }
            calculate()
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