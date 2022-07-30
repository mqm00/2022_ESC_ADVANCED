package generics

open class WaterSupply(var needsProcessing: Boolean)

class TapWater: WaterSupply(true){
    fun addChemicalCleaners(){
        needsProcessing = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true){
    fun filter(){
        needsProcessing = false
    }
}

class Aquarium<T>(val waterSupply: T)

fun genericsExapmle() {
    val aquarium = Aquarium<TapWater>(TapWater())
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
    aquarium.waterSupply.addChemicalCleaners()
    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
}

fun<T: WaterSupply> isWaterClean(aquarium: Aquarium<T>){
    println("aqurium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}


fun main(){
    genericsExapmle()
}