# SilenceUtils-Addon-Replacer

# ⚠ 이 모드를 사용하지 마세요!
이 모드는 더 이상 사일런스 유틸에서 사용하지 않습니다. 왜냐하면 기능이 사일런스 유틸에 내장되었기 때문입니다.  
해당 글을 코드에 관심있는 사람들을 위해서 남겨두겠습니다.  
사일런스 유틸에서는 전혀 다른 방법으로 구현했습니다.  

# 모드 소개
이 모드는 하이픽셀 스카이블럭 게임 중 블럭을 캘 때 들고 있는 아이템의 데이터가 수정되며 캐는 동작이 순간 초기화되는 버그를 해결해 줍니다.
이 문제는 핑이 높을수록 크게 작용하며 특히 마이닝에서 핑에 따라 수익 차이가 매우 크게 나타납니다.
또한 블럭을 캐기전 생기는 딜레이를 제거하여 보다 나은 환경을 제공합니다.

# 요구 사항
이 모드는 사일런스 유틸 모드의 애드온 모드입니다.
1.4.2 이상의 사일런스 유틸 모드가 있어야 하며 사일런스 유틸에서 해당 모드가 제어가 가능합니다.

## Vanilla Code
```java
private boolean isHittingPosition(BlockPos pos)
{
    ItemStack itemstack = this.mc.thePlayer.getHeldItem();
    boolean flag = this.currentItemHittingBlock == null && itemstack == null;
    if (this.currentItemHittingBlock != null && itemstack != null)
    {
        flag = itemstack.getItem() == this.currentItemHittingBlock.getItem() && ItemStack.areItemStackTagsEqual(itemstack, this.currentItemHittingBlock) && (itemstack.isItemStackDamageable() || itemstack.getMetadata() == this.currentItemHittingBlock.getMetadata());
    }
    return pos.equals(this.currentBlock) && flag;
}
```

## Replacer Code
```java
public static boolean isNewHittingPosition(BlockPos pos, ItemStack item, BlockPos currentPos) {
    ItemStack itemstack = mc.thePlayer.getHeldItem(); if (itemstack == null) return false;
    String iName = itemstack.getDisplayName();
    boolean flag = item == null && itemstack == null;
    if (item != null && itemstack != null) {
        if (Main.isEnable() && (iName.contains("Drill") || iName.contains("Gemstone Gauntlet") || iName.contains("Pickonimbus"))) return pos.equals(currentPos);
        flag = itemstack.getItem() == item.getItem() && ItemStack.areItemStackTagsEqual(itemstack, item) && ( itemstack.isItemStackDamageable() || itemstack.getMetadata() == item.getMetadata() );
    }
    return pos.equals(currentPos) && flag;
}
```

# How to Download
여기서 [다운로드](https://github.com/SILENCE-SIMSOOL/SilenceUtils-Addon-Replacer/releases/download/2.1/SUAddon_Replacer-2.1.jar) 하실 수 있습니다.

이 모드는 [Hot-Shirtless-Men](https://github.com/Rekteiru/Hot-Shirtless-Men) 모드에 영감을 받아 제작되었습니다.
