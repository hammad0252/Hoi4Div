package com.company.hoi4divisiondesigner

data class battalion (val name : String, val speed: Double, val hp : Double, val organization : Double, val recoveryRate : Double,
val suppression : Double, val weight : Double, val supplyUse : Double, val fuelUse : Double, val fuelCap : Double,
val manpower : Double, val trainingTime : Double, val industryCost : Double, val softAttack : Double, val hardAttack : Double,
val airAttack : Double, val defence : Double, val breakthrough : Double, val armour : Double, val piercing : Double, val combatWidth : Double,
val hardness : Double){

    companion object {
        private val infantry = battalion(R.string.infantry.toString(), 4.0, 25.0, 60.0, 0.3, 1.5,
            0.5, 0.07, 0.0, 0.0, 1000.0, 90.0, 50.0, 6.0,
            1.0, 0.0, 23.1, 3.15, 0.0, 4.0, 2.0, 0.0
        )

        private val artillery = battalion(R.string.artillery.toString(), 4.0, 0.6, 0.0, 0.1, 0.0,
            0.5, 0.2,0.0,0.0,500.0,120.0,126.0,27.5,2.0,
            0.0,10.0,6.0,0.0,5.0,3.0,0.0)

        private val antiAir = battalion(R.string.anti_air.toString(), 4.0, 0.6, 0.0, 0.1, 0.0,
            0.5, 0.1,0.0,0.0,500.0,120.0,120.0,3.0,7.0,
            19.0,4.0,1.0,0.0,25.0,1.0,0.0)

        private val antiTank = battalion(R.string.anti_tank.toString(), 4.0, 0.6, 0.0, 0.0, 0.0,
            0.5, 0.1,0.0,0.0,500.0,120.0,144.0,4.0,15.0,
            0.0,4.0,0.0,0.0,75.0,1.0,0.0)

        private val rocketArtillery = battalion(R.string.rocket_artillery.toString(), 4.0, 0.6, 0.0, 0.1, 0.0,
            0.5, 0.2,0.0,0.0,500.0,120.0,144.0,30.0,1.0,
            0.0,12.0,9.0,0.0,2.0,3.0,0.0)

        private val mountaineer = battalion(R.string.mountaineer.toString(), 4.0, 20.0, 70.0, 0.4, 1.0,
            0.5, 0.07,0.0,0.0,1000.0,120.0,70.0,6.0,1.0,
            0.0,22.66,3.99,0.0,4.0,2.0,0.0)

        private val paratroopers = battalion(R.string.paratrooper.toString(), 4.0, 22.0, 70.0, 0.4, 1.0,
            0.5, 0.06,0.0,0.0,1000.0,150.0,65.0,6.0,1.0,
            0.0,22.66,3.09,0.0,4.0,2.0,0.0)

        private val marines = battalion(R.string.marine.toString(), 4.0, 20.0, 70.0, 0.4, 1.0,
            0.5, 0.06,0.0,0.0,1000.0,120.0,75.0,6.0,1.0,
            0.0,22.66,3.99,0.0,4.0,22.0,0.0)

        private val bicycle = battalion(R.string.bicycle.toString(), 6.4, 25.0, 60.0, 0.3, 2.0,
            0.5, 0.07,0.0,0.0,1000.0,90.0,90.0,6.0,1.0,
            0.0,23.1,3.15,0.0,4.0,2.0,0.0)

        private val penal = battalion(R.string.penal_battalion.toString(), 4.0, 0.6, 0.0, 0.1, 0.0,
            0.5, 0.2,0.0,0.0,500.0,120.0,126.0,27.5,2.0,
            0.0,10.0,6.0,0.0,5.0,3.0,0.0)

        private val motInfantry = battalion(R.string.motorized_infantry.toString(), 12.0, 25.0, 60.0, 0.3, 2.2,
            0.75, 0.11,1.2,34.56,1200.0,90.0,175.0,6.0,1.0,
            0.0,23.1,3.15,0.0,4.0,2.0,10.0)

        private val motArtillery = battalion(R.string.motorized_artillery.toString(), 12.0, 0.6, 0.0, 0.1, 0.0,
            0.5, 0.3,1.2,34.56,500.0,120.0,251.0,27.5,2.0,
            0.0,10.0,6.0,0.0,5.0,3.0,10.0)

        private val motAntiAir = battalion(R.string.motorized_anti_air.toString(), 12.0, 0.6, 0.0, 0.1, 0.0,
            0.5, 0.15,1.2,34.56,500.0,120.0,245.0,3.0,7.0,
            19.0,4.0,1.0,0.0,25.0,1.0,10.0)

        private val motAntiTank = battalion(R.string.motorized_anti_tank.toString(), 12.0, 0.6, 0.0, 0.0, 0.0,
            0.5, 0.15,1.2,34.56,500.0,120.0,269.0,4.0,15.0,
            0.0,4.0,0.0,0.0,75.0,1.0,10.0)

        private val motRocketArtillery = battalion(R.string.motorized_rocket_artillery.toString(), 12.0, 0.6, 0.0, 0.1, 0.0,
            0.5, 0.28,1.32,38.016,500.0,120.0,277.5,36.0,1.0,
            0.0,15.0,12.0,0.0,2.0,3.0,10.0)

        private val cavalry = battalion(R.string.cavalry.toString(), 6.4, 25.0, 70.0, 0.3, 2.0,
            0.5, 0.12,0.0,0.0,1000.0,120.0,60.0,6.0,1.0,
            0.0,22.44,3.06,0.0,4.0,2.0,0.0)

        private val camel = battalion(R.string.camel.toString(), 5.6, 30.0, 70.0, 0.3, 2.0,
            0.6, 0.1,0.0,0.0,1000.0,160.0,75.0,6.0,1.0,
            0.0,22.0,3.0,0.0,4.0,2.0,0.0)

        private val mechInfantry = battalion(R.string.mechanized_infantry.toString(), 8.0, 30.0, 60.0, 0.3, 2.0,
            1.0, 0.18,2.4,69.12,1200.0,120.0,458.0,10.8,7.5,
            0.0,62.1,9.2,10.0,16.0,2.0,60.0)

        private val amtrac = battalion(R.string.amtrac_battalion.toString(), 7.0, 30.0, 65.0, 0.3, 1.0,
            1.0, 0.18,4.0,115.2,1200.0,120.0,458.0,10.8,2.25,
            0.0,64.8,9.2,10.0,16.0,2.0,60.0)

        private val armouredCar = battalion(R.string.armoured_car.toString(), 9.0, 2.0, 10.0, 0.3, 2.5,
            0.8, 0.14,0.8,23.04,500.0,180.0,240.0,6.0,2.0,
            0.0,2.0,12.0,3.0,6.0,2.0,65.0)

        val allBats = arrayOf(infantry, artillery, antiAir, antiTank, rocketArtillery, mountaineer, paratroopers, marines, bicycle, penal,
        motInfantry, motArtillery, motAntiAir, motAntiTank, motRocketArtillery, cavalry, camel, mechInfantry,
            amtrac, armouredCar)
    }
}
