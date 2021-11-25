package viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import viaversion.viaversion.api.minecraft.item.Item;

public class RecipeData$Recipe {
   private String e;
   private String h;
   private int a;
   private int f;
   private float experience;
   private int d;
   private Item[] ingredient;
   private Item[][] ingredients;
   private Item result;

   public String e() {
      return this.e;
   }

   public void b(String var1) {
      this.e = var1;
   }

   public String i() {
      return this.h;
   }

   public void a(String var1) {
      this.h = var1;
   }

   public int d() {
      return this.a;
   }

   public void b(int var1) {
      this.a = var1;
   }

   public int b() {
      return this.f;
   }

   public void c(int var1) {
      this.f = var1;
   }

   public float getExperience() {
      return this.experience;
   }

   public void setExperience(float var1) {
      this.experience = var1;
   }

   public int f() {
      return this.d;
   }

   public void a(int var1) {
      this.d = var1;
   }

   public Item[] getIngredient() {
      return this.ingredient;
   }

   public void setIngredient(Item[] var1) {
      this.ingredient = var1;
   }

   public Item[][] getIngredients() {
      return this.ingredients;
   }

   public void setIngredients(Item[][] var1) {
      this.ingredients = var1;
   }

   public Item getResult() {
      return this.result;
   }

   public void setResult(Item var1) {
      this.result = var1;
   }
}
