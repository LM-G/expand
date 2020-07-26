package com.solution.expand

import com.solution.expand.util.Constants.Companion.MOD_ID
import net.minecraft.block.Block
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.event.server.FMLServerStartingEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.apache.logging.log4j.LogManager


@Mod(MOD_ID)
class Expand {
  companion object {
    private val LOGGER = LogManager.getLogger()
  }


  init {
    val eventBus = FMLJavaModLoadingContext.get().modEventBus
    eventBus.addListener { event: FMLCommonSetupEvent -> setup(event) }
    eventBus.addListener { event: FMLClientSetupEvent -> doClientStuff(event) }

    //Registrator.start()

    MinecraftForge.EVENT_BUS.register(this)
  }

  private fun setup(event: FMLCommonSetupEvent) {

  }

  private fun doClientStuff(event: FMLClientSetupEvent) {
    // do something that can only be done on the client
    LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings)
  }

  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  fun onServerStarting(event: FMLServerStartingEvent) {
    // do something when the server starts
    LOGGER.info("HELLO from server starting")
  }

  // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
  // Event bus for receiving Registry Events)
  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  object RegistryEvents {
    @SubscribeEvent
    fun onBlocksRegistry(blockRegistryEvent: RegistryEvent.Register<Block>) {
      // register a new block here
      LOGGER.info("HELLO from Register Block")
    }
  }


}