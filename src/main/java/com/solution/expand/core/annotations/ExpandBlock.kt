package com.solution.expand.core.annotations

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@kotlin.annotation.Target(AnnotationTarget.CLASS)
annotation class ExpandBlock(val name: String)