import org.scalameter
import org.scalameter.{Key, Warmer, config}

/**
  * Created by adarsh on 06/07/2017.
  */
object Benchmarker {

  private val standardConfig = config(
    Key.exec.minWarmupRuns -> 5,
    Key.exec.maxWarmupRuns -> 10,
    Key.exec.benchRuns -> 10
    //      ,Key.verbose -> true
  ) withWarmer (new Warmer.Default)

  private val footprintMeasurer = new scalameter.Measurer.MemoryFootprint
  def measureTime(s: =>Any) = standardConfig measure s
  def measureMemory(s: =>Any) = standardConfig withMeasurer footprintMeasurer measure s

}
