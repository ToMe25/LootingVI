var asmapi = Java.type('net.minecraftforge.coremod.api.ASMAPI');
var Opcodes = Java.type('org.objectweb.asm.Opcodes');
var MethodInsnNode = Java.type('org.objectweb.asm.tree.MethodInsnNode');
var FieldInsnNode = Java.type('org.objectweb.asm.tree.FieldInsnNode');
var VarInsnNode = Java.type('org.objectweb.asm.tree.VarInsnNode');
var InsnNode = Java.type('org.objectweb.asm.tree.InsnNode');
var InsnList = Java.type('org.objectweb.asm.tree.InsnList');

function initializeCoreMod() {
    return {
        'damage': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.DamageEnchantment'
            },
            'transformer': function(classNode) {
                return transformDamage(classNode);
            }
        },
        'lootbonus': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.LootBonusEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'LootBonus');
            }
        },
        'protection': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.ProtectionEnchantment'
            },
            'transformer': function(classNode) {
                return transformProtection(classNode);
            }
        },
        'power': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.PowerEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'ArrowDamage');
            }
        },
        'efficiency': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.EfficiencyEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'Digging');
            }
        },
        'unbreaking': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.UnbreakingEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'Durability');
            }
        },
        'thorns': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.ThornsEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'Thorns');
            }
        },
        'respiration': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.RespirationEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'Oxygen');
            }
        },
        'depthstrider': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.DepthStriderEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'WaterWalker');
            }
        },
        'frostwalker': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.FrostWalkerEnchantment'
            },
            'transformer': function(classNode) {
                return transformLevelOnly(classNode, 'FrostWalker');
            }
        },
        'knockback': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.KnockbackEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'Knockback');
            }
        },
        'fireaspect': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.FireAspectEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'FireAspect');
            }
        },
        'punch': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.PunchEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'ArrowKnockback');
            }
        },
        'lure': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.LureEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'FishingSpeed');
            }
        },
        'sweeping': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.SweepingEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'SweepingEdge');
            }
        },
        'loyalty': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.LoyaltyEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'Loyalty');
            }
        },
        'impaling': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.ImpalingEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'Impaling');
            }
        },
        'riptide': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.RiptideEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'Riptide');
            }
        },
        'quickcharge': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.QuickChargeEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'QuickCharge');
            }
        },
        'piercing': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.PiercingEnchantment'
            },
            'transformer': function(classNode) {
                return transform(classNode, 'Piercing');
            }
        }
    }
}

function transformLevelOnly(classNode, configFieldBaseName) {
    var levelConfigFieldName = 'Enchant' + configFieldBaseName + 'Lvl';
    var configHandler = "com/ToMe/LootingMod/ConfigHandler";
    var levelMethodName = asmapi.mapMethod('func_77325_b');
    var methods = classNode.methods;
    var method = null;
    for(var i in methods) {
        if(methods[i].name == levelMethodName) {
            method = methods[i];
            var target = findFirstInstruction(method, Opcodes.IRETURN);
            method.instructions.remove(target.getNext());
            method.instructions.insertBefore(target, new FieldInsnNode(Opcodes.GETSTATIC, configHandler, levelConfigFieldName, 'I'));
        }
    }
    return classNode;
}

function transform(classNode, configFieldBaseName) {
    var levelConfigFieldName = 'Enchant' + configFieldBaseName + 'Lvl';
    var baseEnchantabilityConfigFieldName = 'Enchant' + configFieldBaseName + 'BaseEnchantability';
    var enchantabilityMultiplierConfigFieldName = 'Enchant' + configFieldBaseName + 'EnchantabilityMultiplier';
    var configHandler = "com/ToMe/LootingMod/ConfigHandler";
    var levelMethodName = asmapi.mapMethod('func_77325_b');
    var enchantabilityMethodName = asmapi.mapMethod('func_77321_a');
    var methods = classNode.methods;
    var method = null;
    for(var i in methods) {
        if(methods[i].name == levelMethodName) {
            method = methods[i];
            var target = findFirstInstruction(method, Opcodes.IRETURN);
            method.instructions.remove(target.getNext());
            method.instructions.insertBefore(target, new FieldInsnNode(Opcodes.GETSTATIC, configHandler, levelConfigFieldName, 'I'));
        } else if(methods[i].name == enchantabilityMethodName) {
            method = methods[i];
            var target = removeUntilFirstInstruction(method, Opcodes.IRETURN);
            var toInsert = new InsnList();
            toInsert.add(new VarInsnNode(Opcodes.ILOAD, 1));
            toInsert.add(new InsnNode(Opcodes.ICONST_1));
            toInsert.add(new InsnNode(Opcodes.ISUB));
            toInsert.add(new FieldInsnNode(Opcodes.GETSTATIC, configHandler, enchantabilityMultiplierConfigFieldName, 'I'));
            toInsert.add(new InsnNode(Opcodes.IMUL));
            toInsert.add(new FieldInsnNode(Opcodes.GETSTATIC, configHandler, baseEnchantabilityConfigFieldName, 'I'));
            toInsert.add(new InsnNode(Opcodes.IADD));
            method.instructions.insertBefore(target, toInsert);
        }
    }
    return classNode;
}

function transformDamage(classNode) {
    var levelConfigFieldName = 'EnchantDamageLvl';
    var configHandler = "com/ToMe/LootingMod/ConfigHandler";
    var enchantmentHooks = "com/ToMe/LootingMod/EnchantmentHooks";
    var damageTypeName = asmapi.mapField('field_77361_a');
    var damageEnchantment = 'net/minecraft/enchantment/DamageEnchantment';
    var levelMethodName = asmapi.mapMethod('func_77325_b');
    var enchantabilityMethodName = asmapi.mapMethod('func_77321_a');
    var methods = classNode.methods;
    var method = null;
    for(var i in methods) {
        if(methods[i].name == levelMethodName) {
            method = methods[i];
            var target = findFirstInstruction(method, Opcodes.IRETURN);
            method.instructions.remove(target.getNext());
            method.instructions.insertBefore(target, new FieldInsnNode(Opcodes.GETSTATIC, configHandler, levelConfigFieldName, 'I'));
        } else if(methods[i].name == enchantabilityMethodName) {
            method = methods[i];
            var target = removeUntilFirstInstruction(method, Opcodes.IRETURN);
            var toInsert = new InsnList();
            toInsert.add(new VarInsnNode(Opcodes.ALOAD, 0));
            toInsert.add(new FieldInsnNode(Opcodes.GETFIELD, damageEnchantment, damageTypeName, 'I'));
            toInsert.add(new VarInsnNode(Opcodes.ILOAD, 1));
            toInsert.add(new MethodInsnNode(Opcodes.INVOKESTATIC, enchantmentHooks, 'getDamageEnchantability', '(II)I', false));
            method.instructions.insertBefore(target, toInsert);
        }
    }
    return classNode;
}

function transformProtection(classNode) {
    var levelConfigFieldName = 'EnchantProtectionLvl';
    var configHandler = "com/ToMe/LootingMod/ConfigHandler";
    var enchantmentHooks = "com/ToMe/LootingMod/EnchantmentHooks";
    var protectionTypeName = asmapi.mapField('field_77356_a');
    var protectionTypeDesc = 'Lnet/minecraft/enchantment/ProtectionEnchantment$Type;';
    var protectionEnchantment = 'net/minecraft/enchantment/ProtectionEnchantment';
    var levelMethodName = asmapi.mapMethod('func_77325_b');
    var enchantabilityMethodName = asmapi.mapMethod('func_77321_a');
    var methods = classNode.methods;
    var method = null;
    for(var i in methods) {
        if(methods[i].name == levelMethodName) {
            method = methods[i];
            var target = findFirstInstruction(method, Opcodes.IRETURN);
            method.instructions.remove(target.getNext());
            method.instructions.insertBefore(target, new FieldInsnNode(Opcodes.GETSTATIC, configHandler, levelConfigFieldName, 'I'));
        } else if(methods[i].name == enchantabilityMethodName) {
            method = methods[i];
            var target = removeUntilFirstInstruction(method, Opcodes.IRETURN);
            var toInsert = new InsnList();
            toInsert.add(new VarInsnNode(Opcodes.ALOAD, 0));
            toInsert.add(new FieldInsnNode(Opcodes.GETFIELD, protectionEnchantment, protectionTypeName, protectionTypeDesc));
            toInsert.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, 'java/lang/Enum', 'ordinal', '()I', false));
            toInsert.add(new VarInsnNode(Opcodes.ILOAD, 1));
            toInsert.add(new MethodInsnNode(Opcodes.INVOKESTATIC, enchantmentHooks, 'getProtectionEnchantability', '(II)I', false));
            method.instructions.insertBefore(target, toInsert);
        }
    }
    return classNode;
}

function findFirstInstruction(method, opcode) {
    var instructions = method.instructions.toArray();
    for(var i in instructions) {
        var instruction = instructions[i];
        if(instruction.getOpcode() == opcode) {
            return instruction;
        }
    }
}

function removeUntilFirstInstruction(method, opcode) {
    var instructions = method.instructions.toArray();
    var remove = false;
    for(var i in instructions) {
        var instruction = instructions[i];
        if(instruction.getOpcode() != -1) {
            if(!remove) {
                remove = true;
            }
        }
        if(instruction.getOpcode() == opcode) {
            return instruction;
        }
        if(remove && instruction.getOpcode() != -1) {
            method.instructions.remove(instruction);
        }
    }
}
