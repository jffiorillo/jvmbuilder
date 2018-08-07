package com.example

import io.github.jffiorillo.builder.JvmBuilder


typealias Foo<T, R> = TestDataClass2<T, R>
typealias Bar = TestDataClass2<String, Int>

class IntArrayList : ArrayList<Int>()

@JvmBuilder
data class TestDataClass1(val counter: Int = 1, val name: List<String?>) {

  constructor() : this(0, listOf())

  fun copy(): TestDataClass1 = TestDataClass1()
  fun copy(name: List<String?>): TestDataClass1 = TestDataClass1(counter = this.counter, name = name)
}

@JvmBuilder
@Suppress("AddVarianceModifier")
data class TestDataClass2<out T, R>(val generic1: T, val generic2: R)

@JvmBuilder
data class TestDataClass3<out T : Any, R>(val foo: Foo<T, R>, val bar: Bar?)

@JvmBuilder
data class TestDataClass4<Z, out T : TestDataClass2<Z, Z>, R>(val a: TestDataClass2<T, R>, val b: TestDataClass2<Z, *>)

@JvmBuilder(prefix = "copyIfNecessary")
data class TestDataClass5<out T, R>(val foo: Foo<T, R>, val list: IntArrayList?, val mList: MutableList<Any?>?)

@JvmBuilder
data class TestDataClass6(val a: Int, val b: String = "foo")

class Parent {
  @JvmBuilder
  data class TestDataClass6<out T, R>(val foo: Foo<T, R>, val list: IntArrayList?) where R : Any, R : Runnable
}

@JvmBuilder
data class Test(val foo: Int = 1, val bar: String)
