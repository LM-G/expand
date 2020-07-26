package com.solution.expand.core.services

import com.solution.expand.core.annotations.ExpandBlock
import com.solution.expand.util.Constants.Companion.MOD_ID
import com.solution.expand.util.ReflectionUtils.Companion.getClasses
import net.minecraft.block.Block
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import java.util.function.Supplier


class Registrator {
  companion object {
    val FEATURES_PCKG = "com.solution.expand.features";
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID)
    fun start() {
      val eventBus = FMLJavaModLoadingContext.get().modEventBus
      BLOCKS.register(eventBus)
      initBlocks();
      print("yes")
    }

    private fun initBlocks() {
      val blockClasses = getClasses(FEATURES_PCKG, ExpandBlock::class.java)
      blockClasses.stream()
        .forEach { blockClass: Class<*> ->
          // and instanciates them
          BLOCKS.register(
            blockClass.getAnnotation(ExpandBlock::class.java).name,
            Supplier { Block::class.java.cast(blockClass.newInstance()) })
        }
    }
  }
}