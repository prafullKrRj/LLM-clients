package org.prafull

class Sample {
    private val name = "Prafull"
    fun getName() = name
}
class LLMClient {
    companion object {
        fun getName() : String {
            val sample = Sample()
            return sample.getName()
        }
    }
}