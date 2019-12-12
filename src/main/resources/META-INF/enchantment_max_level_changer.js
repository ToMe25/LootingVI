var asmapi = Java.type('net.minecraftforge.coremod.api.ASMAPI');
var methodName = asmapi.mapMethod('func_77325_b');

function initializeCoreMod() {
    return {
        'damage': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.DamageEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantDamageLvl');
            }
        },
        'lootbonus': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.LootBonusEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantLootBonusLvl');
            }
        },
        'protection': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.ProtectionEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantProtectionLvl');
            }
        },
        'power': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.PowerEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantArrowDamageLvl');
            }
        },
        'efficiency': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.EfficiencyEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantDiggingLvl');
            }
        },
        'unbreaking': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.UnbreakingEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantDurabilityLvl');
            }
        },
        'thorns': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.ThornsEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantThornsLvl');
            }
        },
        'respiration': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.RespirationEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantOxygenLvl');
            }
        },
        'depthstrider': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.DepthStriderEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantWaterWalkerLvl');
            }
        },
        'frostwalker': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.FrostWalkerEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantFrostWalkerLvl');
            }
        },
        'knockback': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.KnockbackEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantKnockbackLvl');
            }
        },
        'fireaspect': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.FireAspectEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantFireAspectLvl');
            }
        },
        'punch': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.PunchEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantArrowKnockbackLvl');
            }
        },
        'lure': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.LureEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantFishingSpeedLvl');
            }
        },
        'sweeping': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.SweepingEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantSweepingEdgeLvl');
            }
        },
        'loyalty': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.LoyaltyEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantLoyaltyLvl');
            }
        },
        'impaling': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.ImpalingEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantImpalingLvl');
            }
        },
        'riptide': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.RiptideEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantRiptideLvl');
            }
        },
        'quickcharge': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.QuickChargeEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantQuickChargeLvl');
            }
        },
        'piercing': {
            'target': {
                'type': 'CLASS',
                'name': 'net.minecraft.enchantment.PiercingEnchantment'
            },
            'transformer': function(classNode) {
                return changeMaxLevel(classNode, 'EnchantPiercingLvl');
            }
        }
    }
}

function changeMaxLevel(classNode, configField) {
    var Opcodes = Java.type('org.objectweb.asm.Opcodes');
    var FieldInsnNode = Java.type('org.objectweb.asm.tree.FieldInsnNode');
    var owner = "com/ToMe/LootingMod/ConfigHandler";
    var methods = classNode.methods;
    var method = null;
    for(var i in methods) {
        if(methods[i].name == methodName) {
            method = methods[i];
            break;
        }
    }
    var target = findFirstInstruction(method, Opcodes.IRETURN);
    method.instructions.remove(target.getNext());
    method.instructions.insertBefore(target, new FieldInsnNode(Opcodes.GETSTATIC, owner, configField, 'I'));
    return classNode;
}

function findFirstInstruction(method, opcode) {
    var instructions = method.instructions;
    for(var i = 0; i < instructions.size(); i++) {
        var instruction = instructions.get(i);
        if(instruction.getOpcode() == opcode) {
            return instruction;
        }
    }
}
