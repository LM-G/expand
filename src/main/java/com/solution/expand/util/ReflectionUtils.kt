package com.solution.expand.util

import org.reflections.Reflections


/**
 * Reflection utilities
 */
class ReflectionUtils private constructor() {
  companion object {
    /**
     * Gets all specified annotated classes
     * @param annotation annotation classe
     * @return all annotated mathching classes
     */
    fun getClasses(
      packageName: String,
      annotation: Class<out Annotation?>
    ): Set<Class<*>> {
      return Reflections(packageName).getTypesAnnotatedWith(annotation)
    }
  }

  /**
   * private constructor
   */
  init {
    throw UnsupportedOperationException("ReflectionUtils constructor must never be called")
  }
}