package viamcp.gui;

import net.aHV;
import net.ag1;
import net.aq9;
import net.axO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.util.EnumChatFormatting;
import us.myles.ViaVersion.api.protocol.ProtocolVersion;

class GuiProtocolSelector$SlotList extends GuiSlot {
   final aHV x;

   public GuiProtocolSelector$SlotList(aHV var1, Minecraft var2, int var3, int var4, int var5, int var6, int var7) {
      super(var2, var3, var4, var5, var6, var7);
      this.x = var1;
   }

   protected int getSize() {
      return ag1.a().size();
   }

   protected void elementClicked(int var1, boolean var2, int var3, int var4) {
      aq9.d = ((ProtocolVersion)ag1.a().get(var1)).d();
   }

   protected boolean isSelected(int var1) {
      return false;
   }

   protected void drawBackground() {
      this.x.drawDefaultBackground();
   }

   protected void drawSlot(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.x.drawCenteredString(this.mc.fontRendererObj, (aq9.d == ((ProtocolVersion)ag1.a().get(var1)).d()?EnumChatFormatting.GREEN.toString():EnumChatFormatting.WHITE.toString()) + axO.a(((ProtocolVersion)ag1.a().get(var1)).d()), this.width / 2, var3 + 2, -1);
   }
}
