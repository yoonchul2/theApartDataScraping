package com.optatum.admin.config

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.BeanNameGenerator
import org.springframework.context.annotation.AnnotationBeanNameGenerator


/**
 *  TODO: 동작 안함, beanName 이 만들어 지는 것 까지 확인 했는데 다음과 같은 에러가 발생함
 *  Annotation-specified bean name 'contractController' for bean class [com.optatum.admin.controller.v2.ContractController]
 *  conflicts with existing, non-compatible bean definition of same name and class [com.optatum.admin.controller.v1.ContractController]
 *  일단 해당 기능을 호출하지 않도록 하고, 코드만 남겨 놓음
 **/
class CustomBeanNameGenerator : BeanNameGenerator {

    /**
     * 기본 BeanNameGenerator
     */
    private val defaultNameGenerator = AnnotationBeanNameGenerator()

    override fun generateBeanName(definition: BeanDefinition, registry: BeanDefinitionRegistry): String {

        return if (isController(definition)) {
            generateFullBeanName(definition as AnnotatedBeanDefinition)
        } else {
            defaultNameGenerator.generateBeanName(definition, registry)
        }
    }

    private fun generateFullBeanName(definition: AnnotatedBeanDefinition): String {
        return definition.metadata.className
    }

    /**
     * BeanDefinition 에서 annotationType 들을 모두 가져오는 함수
     */
    private fun getAnnotationTypes(definition: BeanDefinition): MutableSet<String> {
        val annotatedBeanDefinition = definition as AnnotatedBeanDefinition
        val metadata = annotatedBeanDefinition.metadata
        return metadata.annotationTypes
    }

    /**
     * 빈을 생성하려는 클래스가 Controller 인지 확인 하는 함수
     */
    private fun isController(definition: BeanDefinition): Boolean {
        if (definition is AnnotatedBeanDefinition) {
            val annotationTypes = getAnnotationTypes(definition)

            for (annotationType in annotationTypes) {
                return when (annotationType) {
                    "org.springframework.web.bind.annotation.Controller", "org.springframework.web.bind.annotation.RestController" -> true
                    else -> false
                }
            }
        }
        return false
    }
}