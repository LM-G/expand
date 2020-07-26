package com.solution.expand.features.ores.redstonium;

import com.solution.expand.core.annotations.ExpandBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IWorldReader
import net.minecraftforge.common.ToolType

@ExpandBlock(RedstoniumBlock.NAME)
class RedstoniumBlock : Block(PROPERTIES) {
  companion object {
    const val NAME = "redstonium_ore"
    val PROPERTIES: Properties =
      Properties.create(Material.ROCK)
        .hardnessAndResistance(5.0f, 6.0f)
        .sound(SoundType.STONE)
        .harvestLevel(2)
        .harvestTool(
          ToolType.PICKAXE
        );
  }

  override fun getExpDrop(state: BlockState?, world: IWorldReader?, pos: BlockPos?, fortune: Int, silktouch: Int): Int {
    return 1
  }
}
