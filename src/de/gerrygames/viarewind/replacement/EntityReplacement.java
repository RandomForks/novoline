package de.gerrygames.viarewind.replacement;

import java.util.List;

public interface EntityReplacement {
   int getEntityId();

   void setLocation(double var1, double var3, double var5);

   void relMove(double var1, double var3, double var5);

   void setYawPitch(float var1, float var2);

   void setHeadYaw(float var1);

   void spawn();

   void despawn();

   void updateMetadata(List var1);
}
