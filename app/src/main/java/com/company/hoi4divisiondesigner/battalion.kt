package com.company.hoi4divisiondesigner

import kotlinx.coroutines.newSingleThreadContext

data class battalion (val name : String, var speed: Double, val hp : Double, var organization : Double, val recoveryRate : Double,
                      val suppression : Double, val weight : Double, val supplyUse : Double, val fuelUse : Double, val fuelCap : Double,
                      val manpower : Double, val trainingTime : Double, var industryCost : Double, var softAttack : Double, var hardAttack : Double,
                      var airAttack : Double, var defence : Double, var breakthrough : Double, var armour : Double, var piercing : Double, val combatWidth : Double,
                      var hardness : Double){

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

        private val lightTank = battalion(R.string.light_tank.toString(),12.0,2.0,10.0,0.3,2.5,
        1.0, 0.2, 2.4, 69.12, 500.0, 180.0, 540.0, 16.0, 6.0,
        0.0, 5.0, 36.0, 15.0, 30.0, 2.0, 80.0)

        private val mediumTank = battalion(R.string.medium_tank.toString(), 8.0, 2.0, 10.0, 0.3, 2.5,
        1.25, 0.22, 3.6, 103.68, 500.0, 180.0, 600.0, 19.0, 14.0,
        0.0,5.0, 36.0, 60.0, 61.0, 2.0, 90.0)

        private val heavyTank = battalion(R.string.heavy_tank.toString(), 5.0, 2.0, 10.0, 0.3, 2.5,
            1.5,0.3, 4.14, 126.72, 500.0, 180.0, 1000.0, 15.0, 12.0,
        0.0, 6.0, 36.0, 70.0, 35.0,2.0, 95.0)

        private val superHeavyTank = battalion(R.string.heavy_tank.toString(), 4.0, 2.0,10.0,0.3,2.5,
            1.75, 0.4, 10.0,288.0,500.0,180.0,1500.0, 38.0,45.0,
        0.0,10.0,74.0,145.0,146.0,2.0,99.0)

        private val modernTank = battalion(R.string.modern_tank.toString(), 10.0, 2.0, 10.0, 0.3,2.5,
        1.5,0.25,5.0,144.0,500.0,180.0,1400.0,40.0,32.0,
        0.0,10.0,84.0,130.0,131.0,2.0,98.0)

        fun battalionData (year : Int) : Array<battalion>{
            if (year >= 1938){
                infantry.softAttack = 6.3
                infantry.defence = 24.2
                infantry.breakthrough = 3.3
                mountaineer.softAttack = 6.3
                mountaineer.defence = 23.32
                mountaineer.breakthrough = 4.08
                paratroopers.softAttack = 6.3
                paratroopers.defence = 23.32
                paratroopers.breakthrough = 3.18
                marines.softAttack = 6.3
                marines.defence = 23.32
                marines.breakthrough = 4.08
                bicycle.softAttack = 6.3
                bicycle.defence = 24.2
                bicycle.breakthrough = 3.3
                motInfantry.softAttack = 6.3
                motInfantry.defence = 24.2
                motInfantry.breakthrough = 3.3
                cavalry.softAttack = 6.3
                cavalry.defence = 22.88
                cavalry.breakthrough = 3.12
                if (year >= 1939){
                    infantry.industryCost = 58.0
                    infantry.softAttack = 9.45
                    infantry.hardAttack = 1.5
                    infantry.defence = 30.8
                    infantry.breakthrough = 4.4
                    infantry.piercing = 5.0
                    artillery.industryCost = 144.0
                    artillery.softAttack = 33.0
                    artillery.defence = 15.0
                    artillery.breakthrough = 7.0
                    antiAir.airAttack = 20.9
                    antiTank.hardAttack = 16.5
                    antiTank.piercing = 90.0
                    mountaineer.organization = 75.0
                    mountaineer.industryCost = 81.2
                    mountaineer.softAttack = 9.9
                    mountaineer.hardAttack = 1.5
                    mountaineer.defence = 29.68
                    mountaineer.breakthrough = 5.44
                    mountaineer.piercing = 5.0
                    paratroopers.organization = 75.0
                    paratroopers.industryCost = 75.4
                    paratroopers.softAttack = 9.9
                    paratroopers.hardAttack = 1.5
                    paratroopers.defence = 29.68
                    paratroopers.breakthrough = 4.24
                    paratroopers.piercing = 5.0
                    marines.organization = 75.0
                    marines.industryCost = 87.0
                    marines.softAttack = 9.9
                    marines.hardAttack = 1.5
                    marines.defence = 29.68
                    marines.breakthrough = 5.44
                    marines.piercing = 5.0
                    bicycle.softAttack = 9.45
                    bicycle.hardAttack = 1.5
                    bicycle.defence = 30.8
                    bicycle.breakthrough = 4.4
                    bicycle.piercing = 5.0
                    bicycle.industryCost = 98.0
                    motInfantry.industryCost = 183.0
                    motInfantry.softAttack = 9.45
                    motInfantry.hardAttack = 1.5
                    motInfantry.defence = 30.8
                    motInfantry.breakthrough = 4.4
                    motInfantry.piercing = 5.0
                    motArtillery.industryCost = 269.0
                    motArtillery.softAttack = 33.0
                    motArtillery.defence = 15.0
                    motArtillery.breakthrough = 7.0
                    motAntiAir.airAttack = 20.9
                    motAntiTank.hardAttack = 16.5
                    motAntiTank.piercing = 90.0
                    cavalry.industryCost = 69.6
                    cavalry.softAttack = 9.45
                    cavalry.hardAttack = 1.5
                    cavalry.defence = 29.12
                    cavalry.breakthrough = 4.16
                    cavalry.piercing = 5.0
                    camel.industryCost = 87.0
                    camel.softAttack = 9.0
                    camel.hardAttack = 1.5
                    camel.defence = 28.0
                    camel.breakthrough = 4.0
                    camel.piercing = 5.0
                    if (year >= 1940){
                        infantry.softAttack = 9.9
                        infantry.defence = 32.2
                        infantry.breakthrough = 4.6
                        artillery.softAttack = 36.0
                        antiAir.industryCost = 150.0
                        antiAir.softAttack = 3.5
                        antiAir.hardAttack = 11.0
                        antiAir.airAttack = 27.5
                        antiAir.piercing = 60.0
                        antiTank.industryCost = 180.0
                        antiTank.hardAttack = 24.2
                        antiTank.piercing = 105.6
                        mountaineer.organization = 80.0
                        mountaineer.softAttack = 10.35
                        mountaineer.defence = 31.92
                        mountaineer.breakthrough = 5.56
                        paratroopers.organization = 80.0
                        paratroopers.softAttack = 10.35
                        paratroopers.defence = 31.92
                        paratroopers.breakthrough = 4.36
                        marines.organization = 80.0
                        marines.softAttack = 10.35
                        marines.defence = 31.92
                        marines.breakthrough = 5.56
                        bicycle.softAttack = 9.9
                        bicycle.defence = 32.2
                        bicycle.breakthrough = 4.6
                        motInfantry.softAttack = 9.9
                        motInfantry.defence = 32.2
                        motInfantry.breakthrough = 4.6
                        motInfantry.hardness = 20.0
                        motArtillery.softAttack = 36.0
                        motAntiAir.industryCost = 275.0
                        motAntiAir.softAttack = 3.5
                        motAntiAir.hardAttack = 11.0
                        motAntiAir.airAttack = 27.5
                        motAntiAir.piercing = 60.0
                        motAntiAir.hardness = 20.0
                        motAntiTank.industryCost = 305.0
                        motAntiTank.hardAttack = 24.2
                        motAntiTank.piercing = 105.6
                        motAntiTank.hardness = 20.0
                        cavalry.softAttack = 9.9
                        cavalry.defence = 29.68
                        cavalry.breakthrough = 4.24
                        if (year >= 1941) {
                            artillery.softAttack = 39.0
                            antiAir.airAttack = 30.0
                            antiTank.hardAttack = 26.4
                            antiTank.piercing = 114.4
                            rocketArtillery.softAttack = 34.5
                            motArtillery.softAttack = 39.0
                            motAntiAir.airAttack = 30.0
                            motAntiTank.hardAttack = 26.4
                            motAntiTank.piercing = 114.4
                            motRocketArtillery.softAttack = 41.4
                            if (year >= 1942) {
                                infantry.industryCost = 69.0
                                infantry.softAttack = 13.2
                                infantry.hardAttack = 2.5
                                infantry.defence = 40.8
                                infantry.breakthrough = 6.0
                                infantry.piercing = 20.0
                                artillery.industryCost = 162.0
                                artillery.softAttack = 44.2
                                artillery.defence = 18.0
                                artillery.breakthrough = 8.0
                                antiAir.airAttack = 32.5
                                antiTank.hardAttack = 28.6
                                antiTank.piercing = 123.2
                                rocketArtillery.softAttack = 39.0
                                mountaineer.industryCost = 96.6
                                mountaineer.softAttack = 13.8
                                mountaineer.hardAttack = 2.5
                                mountaineer.defence = 39.78
                                mountaineer.breakthrough = 7.1
                                mountaineer.piercing = 20.0
                                paratroopers.industryCost = 89.7
                                paratroopers.softAttack = 13.7
                                paratroopers.hardAttack = 2.5
                                paratroopers.defence = 39.78
                                paratroopers.breakthrough = 5.6
                                paratroopers.piercing = 20.0
                                marines.industryCost = 103.5
                                marines.softAttack = 13.8
                                marines.hardAttack = 2.5
                                marines.defence = 39.78
                                marines.breakthrough = 7.1
                                marines.piercing = 20.0
                                bicycle.industryCost = 109.0
                                bicycle.softAttack = 13.2
                                bicycle.hardAttack = 2.5
                                bicycle.defence = 40.8
                                bicycle.breakthrough = 6.0
                                bicycle.piercing = 20.0
                                motInfantry.industryCost = 194.0
                                motInfantry.softAttack = 13.2
                                motInfantry.hardAttack = 2.5
                                motInfantry.defence = 40.8
                                motInfantry.breakthrough = 6.0
                                motInfantry.piercing = 20.0
                                motArtillery.industryCost = 287.0
                                motArtillery.softAttack = 44.2
                                motArtillery.defence = 18.0
                                motArtillery.breakthrough = 8.0
                                motAntiAir.airAttack = 32.5
                                motAntiTank.hardAttack = 28.6
                                motAntiTank.piercing = 123.2
                                motRocketArtillery.softAttack = 46.8
                                cavalry.industryCost = 82.8
                                cavalry.softAttack = 13.2
                                cavalry.hardAttack = 2.0
                                cavalry.defence = 36.72
                                cavalry.breakthrough = 5.4
                                cavalry.piercing = 10.0
                                camel.industryCost = 103.5
                                camel.softAttack = 12.0
                                camel.hardAttack = 2.0
                                camel.defence = 34.0
                                camel.breakthrough = 5.0
                                camel.piercing = 10.0
                                mechInfantry.speed = 10.0
                                mechInfantry.industryCost = 569.0
                                mechInfantry.softAttack = 14.4
                                mechInfantry.hardAttack = 10.5
                                mechInfantry.defence = 76.8
                                mechInfantry.breakthrough = 12.0
                                mechInfantry.armour = 15.0
                                mechInfantry.piercing = 52.0
                                mechInfantry.hardness = 70.0
                                if (year >= 1943) {
                                    infantry.hardAttack = 3.0
                                    infantry.piercing = 30.0
                                    artillery.softAttack = 47.6
                                    antiAir.industryCost = 180.0
                                    antiAir.softAttack = 4.0
                                    antiAir.hardAttack = 15.0
                                    antiAir.airAttack = 41.6
                                    antiAir.piercing = 88.0
                                    antiTank.industryCost = 216.0
                                    antiTank.hardAttack = 39.0
                                    antiTank.piercing = 151.2
                                    rocketArtillery.industryCost = 180.0
                                    rocketArtillery.softAttack = 49.4
                                    rocketArtillery.defence = 15.0
                                    rocketArtillery.breakthrough = 12.0
                                    mountaineer.organization = 85.0
                                    mountaineer.hardAttack = 3.0
                                    mountaineer.piercing = 30.0
                                    paratroopers.organization = 85.0
                                    paratroopers.hardAttack = 3.0
                                    paratroopers.piercing = 30.0
                                    marines.organization = 85.0
                                    marines.hardAttack = 3.0
                                    marines.piercing = 30.0
                                    bicycle.hardAttack = 3.0
                                    bicycle.piercing = 30.0
                                    motInfantry.hardAttack = 3.0
                                    motInfantry.piercing = 30.0
                                    motArtillery.softAttack = 47.6
                                    motAntiAir.industryCost = 305.0
                                    motAntiAir.softAttack = 4.0
                                    motAntiAir.hardAttack = 15.0
                                    motAntiAir.airAttack = 41.6
                                    motAntiAir.piercing = 88.0
                                    motAntiTank.industryCost = 341.0
                                    motAntiTank.hardAttack = 39.0
                                    motAntiTank.piercing = 151.2
                                    motRocketArtillery.softAttack = 57.6
                                    if (year >= 1944) {
                                        infantry.softAttack = 13.8
                                        rocketArtillery.softAttack = 51.3
                                        mountaineer.organization = 90.0
                                        mountaineer.softAttack = 15.0
                                        paratroopers.organization = 90.0
                                        paratroopers.softAttack = 15.0
                                        marines.organization = 90.0
                                        marines.softAttack = 15.0
                                        bicycle.softAttack = 13.8
                                        motInfantry.softAttack = 14.4
                                        motRocketArtillery.softAttack = 59.4
                                        cavalry.softAttack = 14.4
                                        if (year >= 1945){
                                            rocketArtillery.softAttack = 53.2
                                            motRocketArtillery.softAttack = 61.2
                                            if (year >= 1946){
                                                rocketArtillery.softAttack = 55.1
                                                motRocketArtillery.softAttack = 63.0
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return arrayOf(
                infantry,
                artillery,
                antiAir,
                antiTank,
                rocketArtillery,
                mountaineer,
                paratroopers,
                marines,
                bicycle,
                motInfantry,
                motArtillery,
                motAntiAir,
                motAntiTank,
                motRocketArtillery,
                cavalry,
                camel,
                mechInfantry,
                amtrac,
                armouredCar,
                lightTank,
                mediumTank,
                heavyTank,
                superHeavyTank,
                modernTank
            )
        }
    }
}
