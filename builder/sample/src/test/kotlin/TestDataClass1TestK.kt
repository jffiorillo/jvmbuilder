import com.example.JvmBuilder_TestDataClass1
import com.pholser.junit.quickcheck.Property
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.runner.RunWith

@RunWith(JUnitQuickcheck::class)
internal class TestDataClass1TestK {

  @Property
  internal fun `should create builder`(counter: Int, name: String?) {
    val (counter1, name1) = JvmBuilder_TestDataClass1().counter(counter).name(arrayListOf(name)).build()

    assertEquals(counter, counter1)
    assertEquals(arrayListOf(name), name1)
  }
}