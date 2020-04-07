package com.ToMe.LootingMod;

//import net.minecraft.client.Minecraft;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.server.MinecraftServer;
//import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
import java.lang.reflect.Field;

//import java.util.Arrays;
//import java.util.function.Supplier;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
//import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
//import org.objectweb.asm.tree.LabelNode;
//import org.objectweb.asm.tree.LocalVariableNode;
//import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
//import org.objectweb.asm.tree.VarInsnNode;
//import net.minecraftforge.common.config.Configuration;
//import net.minecraft.enchantment.EnchantmentArrowInfinite;
import org.objectweb.asm.tree.VarInsnNode;

import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.enchantment.EnchantmentLootBonus;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.enchantment.EnchantmentArrowDamage;

public class ClassTransformer implements IClassTransformer {
	
	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass) {
		// TODO Auto-generated method stub
		//System.out.println(Minecraft.getMinecraft().mcDataDir.getAbsolutePath());
		boolean isObfuscated = !name.equals(transformedName);
		//System.out.println("Hallo Welt!");
		if(transformedName.startsWith("net.minecraft.enchantment") && !transformedName.endsWith(".Enchantment") && !transformedName.contains(".EnumEnchantmentType")) {
			if(LootingMod.cfg == null) {
				File cfg = new File(".", "config");
				cfg = new File(cfg.getPath(), "lootingmod.cfg");
				LootingMod.cfg = new ConfigHandler(cfg);
			}
		}
		if(transformedName.equals("net.minecraft.enchantment.EnchantmentDamage")) {
			//if(LootingMod.cfg == null) {
				//File cfg = new File(Minecraft.getMinecraft().mcDataDir, "config");
				//File cfg = new File(".", "config");
				//cfg = new File(cfg.getPath(), "lootingmod.cfg");
				//LootingMod.cfg = new ConfigHandler(cfg);
			//}
			//System.out.println(Minecraft.getMinecraft().mcDataDir.getAbsolutePath());
			try {
				//ClassNode classNode = new ClassNode();
				//ClassReader classReader = new ClassReader(basicClass);
				//classReader.accept(classNode, 0);
				//for(MethodNode method:classNode.methods) {
					//if(method.name.equals(anObject))
				//}
				//FMLLog.info(null, "Transforming " + classNode.name);
				//System.out.println(isObfuscated);
				//TransformEnchant(classNode, isObfuscated);
				//ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
				//classNode.accept(classWriter);
				//return classWriter.toByteArray();
				//System.out.println("Hallo Welt!");
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantDamageLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantDamageLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantDamageLvl");
				//transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantDamageBaseEnchantability", "EnchantDamageEnchantabilityMultiplier");
				transformedClass = changeDamageEnchantablitity(transformedClass, isObfuscated, name);
				return transformedClass;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentLootBonus")) {
			//if(LootingMod.cfg == null) {
				//File cfg = new File(Minecraft.getMinecraft().mcDataDir, "config");
				//File cfg = new File(".", "config");
				//cfg = new File(cfg.getPath(), "lootingmod.cfg");
				//LootingMod.cfg = new ConfigHandler(cfg);
			//}
			try {
				//ClassNode classNode = new ClassNode();
				//ClassReader classReader = new ClassReader(basicClass);
				//classReader.accept(classNode, 0);
				//TransformEnchant(classNode, isObfuscated);
				//ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
				//classNode.accept(classWriter);
				//return classWriter.toByteArray();
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantLootBonusLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantLootBonusLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantLootBonusLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantLootBonusBaseEnchantability", "EnchantLootBonusEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentProtection")) {
			//if(LootingMod.cfg == null) {
				//File cfg = new File(Minecraft.getMinecraft().mcDataDir, "config");
				//File cfg = new File(".", "config");
				//cfg = new File(cfg.getPath(), "lootingmod.cfg");
				//LootingMod.cfg = new ConfigHandler(cfg);
			//}
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantProtectionLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantProtectionLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantProtectionLvl");
				//transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantProtectionBaseEnchantability", "EnchantProtectionEnchantabilityMultiplier");
				transformedClass = changeProtectionEnchantablitity(transformedClass, isObfuscated, name);
				return transformedClass;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentArrowDamage")) {
			//if(LootingMod.cfg == null) {
				//File cfg = new File(Minecraft.getMinecraft().mcDataDir, "config");
				//File cfg = new File(".", "config");
				//cfg = new File(cfg.getPath(), "lootingmod.cfg");
				//LootingMod.cfg = new ConfigHandler(cfg);
			//}
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantArrowDamageLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantArrowDamageLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantArrowDamageLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantArrowDamageBaseEnchantability", "EnchantArrowDamageEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentDigging")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantDiggingLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantDiggingLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantDiggingLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantDiggingBaseEnchantability", "EnchantDiggingEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentDurability")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantDurabilityLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantDurabilityLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantDurabilityLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantDurabilityBaseEnchantability", "EnchantDurabilityEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentThorns")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantThornsLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantThornsLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantThornsLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantThornsBaseEnchantability", "EnchantThornsEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentOxygen")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantOxygenLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantOxygenLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantOxygenLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantOxygenBaseEnchantability", "EnchantOxygenEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentWaterWalker")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantWaterWalkerLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantWaterWalkerLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantWaterWalkerLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantWaterWalkerBaseEnchantability", "EnchantWaterWalkerEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentFrostWalker")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantFrostWalkerLvl);
				return changeMaxLevel(basicClass, isObfuscated, "EnchantFrostWalkerLvl");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentKnockback")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantKnockbackLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantKnockbackLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantKnockbackLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantKnockbackBaseEnchantability", "EnchantKnockbackEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentFireAspect")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantFireAspectLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantFireAspectLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantFireAspectLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantFireAspectBaseEnchantability", "EnchantFireAspectEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentArrowKnockback")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantArrowKnockbackLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantArrowKnockbackLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantArrowKnockbackLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantArrowKnockbackBaseEnchantability", "EnchantArrowKnockbackEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentFishingSpeed")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantFishingSpeedLvl);
				//return changeMaxLevel(basicClass, isObfuscated, "EnchantFishingSpeedLvl");
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantFishingSpeedLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantFishingSpeedBaseEnchantability", "EnchantFishingSpeedEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(transformedName.equals("net.minecraft.enchantment.EnchantmentSweepingEdge")) {
			try {
				//return changeMaxLevel(basicClass, isObfuscated, LootingMod.cfg.EnchantSweepingEdgeLvl);
				byte[] transformedClass = changeMaxLevel(basicClass, isObfuscated, "EnchantSweepingEdgeLvl");
				transformedClass = changeEnchantablitity(transformedClass, isObfuscated, "EnchantSweepingEdgeBaseEnchantability", "EnchantSweepingEdgeEnchantabilityMultiplier");
				return transformedClass;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return basicClass;
		//return null;
	}
	
	//protected byte[] changeMaxLevel(byte[] startClass, boolean obfuscated, int maxLevel) {
	protected byte[] changeMaxLevel(byte[] startClass, boolean obfuscated, String configField) {
		try {
			ClassNode classNode = new ClassNode();
			ClassReader classReader = new ClassReader(startClass);
			classReader.accept(classNode, 0);
			final String METHOD_NAME = obfuscated ? "b" : "getMaxLevel";
			//final String METHOD_DESCRIPTOR = obfuscated ? "()I" : "()I";
			final String METHOD_DESCRIPTOR = "()I";
		    final String OWNER = "com/ToMe/LootingMod/ConfigHandler";
			for(MethodNode method:classNode.methods) {
				if(method.name.equals(METHOD_NAME) && method.desc.equals(METHOD_DESCRIPTOR)) {
					AbstractInsnNode targetNode = null;
					for (AbstractInsnNode instruction : method.instructions.toArray()) {
						if (instruction.getOpcode() == Opcodes.IRETURN) {
							targetNode = instruction;
							break;
						}
					}
					if (targetNode != null) {
						method.instructions.remove(targetNode.getNext());
						InsnList toInsert = new InsnList();
						//toInsert.add(new InsnNode(Opcodes.ICONST_0));
						//while(maxLevel >= 5) {
							//toInsert.add(new InsnNode(Opcodes.ICONST_5));
							//toInsert.add(new InsnNode(Opcodes.IADD));
							//maxLevel -= 5;
						//}
						//Class c = Opcodes.class;
						//Field Iconst = c.getDeclaredField("ICONST_" + maxLevel);
						//toInsert.add(new InsnNode(Iconst.getInt(Iconst)));
						//toInsert.add(new InsnNode(Opcodes.IADD));
						toInsert.add(new FieldInsnNode(Opcodes.GETSTATIC, OWNER, configField, "I"));
						method.instructions.insertBefore(targetNode, toInsert);
						ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
						classNode.accept(classWriter);
						return classWriter.toByteArray();
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return startClass;
	}
	
	protected byte[] changeEnchantablitity(byte[] startClass, boolean obfuscated, String baseConfigField, String multiplierConfigField) {
		try {
			ClassNode classNode = new ClassNode();
			ClassReader classReader = new ClassReader(startClass);
			classReader.accept(classNode, 0);
			final String METHOD_NAME = obfuscated ? "a" : "getMinEnchantability";
			final String METHOD_DESCRIPTOR = "(I)I";
		    final String OWNER = "com/ToMe/LootingMod/ConfigHandler";
			for(MethodNode method:classNode.methods) {
				if(method.name.equals(METHOD_NAME) && method.desc.equals(METHOD_DESCRIPTOR)) {
					AbstractInsnNode targetNode = null;
					boolean remove = false;
					for (AbstractInsnNode instruction : method.instructions.toArray()) {
						if(!remove && instruction.getOpcode() != -1) {
							remove = true;
						}
						if (instruction.getOpcode() == Opcodes.IRETURN) {
							targetNode = instruction;
							break;
						}
						if(remove) {
							method.instructions.remove(instruction);
						}
					}
					if (targetNode != null) {
						method.instructions.remove(targetNode.getNext());
						InsnList toInsert = new InsnList();
						toInsert.add(new VarInsnNode(Opcodes.ILOAD, 1));
						toInsert.add(new InsnNode(Opcodes.ICONST_1));
						toInsert.add(new InsnNode(Opcodes.ISUB));
						toInsert.add(new FieldInsnNode(Opcodes.GETSTATIC, OWNER, multiplierConfigField, "I"));
						toInsert.add(new InsnNode(Opcodes.IMUL));
						toInsert.add(new FieldInsnNode(Opcodes.GETSTATIC, OWNER, baseConfigField, "I"));
						toInsert.add(new InsnNode(Opcodes.IADD));
						method.instructions.insertBefore(targetNode, toInsert);
						ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
						classNode.accept(classWriter);
						return classWriter.toByteArray();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return startClass;
	}
	
	protected byte[] changeDamageEnchantablitity(byte[] startClass, boolean obfuscated, String className) {
		try {
			ClassNode classNode = new ClassNode();
			ClassReader classReader = new ClassReader(startClass);
			classReader.accept(classNode, 0);
			final String METHOD_NAME = obfuscated ? "a" : "getMinEnchantability";
			final String METHOD_DESCRIPTOR = "(I)I";
		    final String OWNER = "com/ToMe/LootingMod/EnchantmentHooks";
		    final String DAMAGE_TYPE_NAME = obfuscated ? "a" : "damageType";
			for(MethodNode method:classNode.methods) {
				if(method.name.equals(METHOD_NAME) && method.desc.equals(METHOD_DESCRIPTOR)) {
					AbstractInsnNode targetNode = null;
					boolean remove = false;
					for (AbstractInsnNode instruction : method.instructions.toArray()) {
						if(!remove && instruction.getOpcode() != -1) {
							remove = true;
						}
						if (instruction.getOpcode() == Opcodes.IRETURN) {
							targetNode = instruction;
							break;
						}
						if(remove) {
							method.instructions.remove(instruction);
						}
					}
					if (targetNode != null) {
						method.instructions.remove(targetNode.getNext());
						InsnList toInsert = new InsnList();
						toInsert.add(new VarInsnNode(Opcodes.ALOAD, 0));
						toInsert.add(new FieldInsnNode(Opcodes.GETFIELD, className, DAMAGE_TYPE_NAME, "I"));
						toInsert.add(new VarInsnNode(Opcodes.ILOAD, 1));
						toInsert.add(new MethodInsnNode(Opcodes.INVOKESTATIC, OWNER, "getDamageEnchantability", "(II)I", false));
						method.instructions.insertBefore(targetNode, toInsert);
						ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
						classNode.accept(classWriter);
						return classWriter.toByteArray();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return startClass;
	}
	
	protected byte[] changeProtectionEnchantablitity(byte[] startClass, boolean obfuscated, String className) {
		try {
			ClassNode classNode = new ClassNode();
			ClassReader classReader = new ClassReader(startClass);
			classReader.accept(classNode, 0);
			final String METHOD_NAME = obfuscated ? "a" : "getMinEnchantability";
			final String METHOD_DESCRIPTOR = "(I)I";
		    final String OWNER = "com/ToMe/LootingMod/EnchantmentHooks";
		    final String PROTECTION_TYPE_NAME = obfuscated ? "a" : "protectionType";
		    final String PROTECTION_TYPE_DESC = "L" + className + "$a;";
			for(MethodNode method:classNode.methods) {
				if(method.name.equals(METHOD_NAME) && method.desc.equals(METHOD_DESCRIPTOR)) {
					AbstractInsnNode targetNode = null;
					boolean remove = false;
					for (AbstractInsnNode instruction : method.instructions.toArray()) {
						if(!remove && instruction.getOpcode() != -1) {
							remove = true;
						}
						if (instruction.getOpcode() == Opcodes.IRETURN) {
							targetNode = instruction;
							break;
						}
						if(remove) {
							method.instructions.remove(instruction);
						}
					}
					if (targetNode != null) {
						method.instructions.remove(targetNode.getNext());
						InsnList toInsert = new InsnList();
						toInsert.add(new VarInsnNode(Opcodes.ALOAD, 0));
						toInsert.add(new FieldInsnNode(Opcodes.GETFIELD, className, PROTECTION_TYPE_NAME, PROTECTION_TYPE_DESC));
						toInsert.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/lang/Enum", "ordinal", "()I", false));
						toInsert.add(new VarInsnNode(Opcodes.ILOAD, 1));
						toInsert.add(new MethodInsnNode(Opcodes.INVOKESTATIC, OWNER, "getProtectionEnchantability", "(II)I", false));
						method.instructions.insertBefore(targetNode, toInsert);
						ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
						classNode.accept(classWriter);
						return classWriter.toByteArray();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return startClass;
	}
	
	/*protected static void TransformEnchant(ClassNode classNode, boolean obfuscated) {
		//System.out.println("Patching " + classNode.name);
		final String METHOD_NAME = obfuscated ? "b" : "getMaxLevel";
		final String METHOD_DESCRIPTOR = obfuscated ? "()I" : "()I";
		for(MethodNode method:classNode.methods) {
			//System.out.println(method.name);
			if(method.name.equals(METHOD_NAME) && method.desc.equals(METHOD_DESCRIPTOR)) {
				//System.out.println("Found It!");
				//System.out.println(method.desc);
				//System.out.println(method.name);
				AbstractInsnNode targetNode = null;
				for (AbstractInsnNode instruction : method.instructions.toArray())
				{
					//System.out.println(instruction);
					//System.out.println(instruction + ", Opcode = " + instruction.getOpcode());
					if (instruction.getOpcode() == /*Opcodes.RETURN)//*//*Opcodes.ALOAD*//*Opcodes.IRETURN)
					{
						//System.out.println(instruction.getNext());
						//System.out.println(((VarInsnNode)instruction).var);
						//System.out.println(((VarInsnNode)instruction.getNext()).var);
						//System.out.println(instruction.getType());
						targetNode = instruction;
						//System.out.println(targetNode);
						break;
						/*if (((VarInsnNode)instruction).var == 1 && instruction.getNext().getOpcode() == Opcodes.INSTANCEOF)
						{
							targetNode = instruction;
							//System.out.println(targetNode);
							break;
						}*//*
					}
				}
				if (targetNode != null)
				{
					
					//System.out.println(targetNode);
					//System.out.println(targetNode.getPrevious());
					//System.out.println(targetNode.getPrevious().getType());
					//System.out.println(targetNode.getPrevious().INT_INSN);
					//System.out.println(targetNode.getPrevious().INSN);
					//System.out.println(targetNode.getPrevious().getOpcode());
					//System.out.println(Opcodes.ACC_STATIC);
					//System.out.println(targetNode.getNext().getNext());
					//System.out.println(targetNode.getPrevious().getPrevious());
					//System.out.println(targetNode.getPrevious().getPrevious().getPrevious());
					//System.out.println(targetNode.getNext());
					//System.out.println(targetNode.getOpcode());
					//System.out.println(targetNode.getPrevious().VAR_INSN);
					//method.instructions.remove(targetNode.getPrevious());
					//System.out.println(targetNode.getPrevious());
					//targetNode = targetNode.getPrevious();
					method.instructions.remove(targetNode.getNext());
					//while (targetNode.getOpcode() != Opcodes.IRETURN)
					//{
						//targetNode = targetNode.getNext();
						//method.instructions.remove(targetNode.getPrevious());
					//}
					
					InsnList toInsert = new InsnList();
					//toInsert.add(new InsnNode(Opcodes.ICONST_0));
					//toInsert.add(new InsnNode(Opcodes.ACC_STRICT));
					//toInsert.add(new InsnNode(Opcodes.LCONST_0));
					//toInsert.add(new MethodInsnNode(Opcodes.INVOKESTATIC, Type.getInternalName(com.ToMe.LootingMod.ClassTransformer.class), "Output", "()V", false));
					//toInsert.add(new MethodInsnNode(Opcodes.INVOKESTATIC, Type.getInternalName(java.io.PrintStream.class), "Systom.out.Println", "(true)V", false));
					//toInsert.add(new MethodInsnNode(Opcodes.INVOKESTATIC, Type.getInternalName(java.io.PrintStream.class), "Systom.out.Println(true);", "(Z)V", false));
					//toInsert.add(new VarInsnNode(Opcodes.ALOAD, 6));
					//toInsert.add(new VarInsnNode(Opcodes.ALOAD, 0));
					//toInsert.add(new VarInsnNode(Opcodes.ALOAD, 1));
					//toInsert.add(new InsnNode(Opcodes.IRETURN));
					//toInsert.add(new LabelNode(label));
					toInsert.add(new InsnNode(Opcodes.ICONST_5));
					toInsert.add(new InsnNode(Opcodes.ICONST_1));
					toInsert.add(new InsnNode(Opcodes.IADD));
					//toInsert.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, Type.getInternalName(net.minecraft.enchantment.Enchantment.class), (obfuscated ? "func_77325_b" : "getMaxLevel"), METHOD_DESCRIPTOR, false));
					method.instructions.insertBefore(targetNode, toInsert);
					//method.instructions.insert(targetNode, toInsert);
					//System.out.println(method.instructions.getLast());
					//System.out.println(method.instructions);
					//System.out.println(method.localVariables);
					//System.out.println(method.localVariables.get(0));
					//LocalVariableNode var = method.localVariables.get(0);
					//System.out.println(var.name);
					//System.out.println(var.start);
					//System.out.println(var.end);
					//System.out.println(var.index);
					//for (AbstractInsnNode instruction : method.instructions.toArray()) {
						//if(instruction instanceof VarInsnNode) {
							//System.out.println(((VarInsnNode)instruction).var);
						//}
					//}
					
				}
			}
		}
	}*/
	
	/*public static void Output() {
		System.out.println("Test Output!");
	}*/
	
}
