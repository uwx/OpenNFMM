package nfm.open;

public class PlayerData {
    private static final transient long ml = Long.MAX_VALUE;
    public static final transient long[] levelCaps = { //XPHex.txt
            0x0L, 0x03E8L, 0x09C4L, 0x01388L, 0x0251CL, 0x042CCL, 0x074E5L, 0x0C90FL, 0x0155CCL, 0x0222E1L, 0x033F41L,
            0x04AD02L, 0x065BEEL, 0x083408L, 0x0A410AL, 0x0CB70DL, 0x0FA3B6L, 0x0131487L, 0x017200DL, 0x01BD7BEL,
            0x0214CC7L, 0x0278F70L, 0x02EAE60L, 0x036CDBEL, 0x04002BDL, 0x04A6164L, 0x055FBD9L, 0x062E1A0L, 0x0711EC9L,
            0x080D80FL, 0x0921BECL, 0x0A51A6FL, 0x0BA1245L, 0x0D124EBL, 0x0EAA8E9L, 0x0106D1A9L, 0x0126182EL,
            0x0148CC2FL, 0x016F4454L, 0x0199DEB0L, 0x01C90142L, 0x01FD1A7DL, 0x0236A1D5L, 0x02761850L, 0x02BB67C9L,
            0x0308570BL, 0x035DBCC7L, 0x03BC874EL, 0x0425BF26L, 0x049A89EFL, 0x051D5B4BL, 0x05AEB1F8L, 0x06502A97L,
            0x07038F93L, 0x07CADE3BL, 0x08A94BBEL, 0x09A0863DL, 0x0AB3519FL, 0x0BE4C0BDL, 0x0D383E2AL, 0x0EB3472DL,
            0x01058C3E2L, 0x0122D7578L, 0x01436A571L, 0x0167A34E7L, 0x019018E0EL, 0x01BD1BAD5L, 0x01EF2ECA7L,
            0x0226E40E0L, 0x0264DDB60L, 0x02AA1EB35L, 0x02F73310CL, 0x034CFD302L, 0x03AC7907BL, 0x0416BF06DL,
            0x048D8D48CL, 0x0511D78F5L, 0x05A525A87L, 0x06492BDA2L, 0x06FFCFEEFL, 0x07D6D467CL, 0x08C7A636CL,
            0x09D55DFFFL, 0x0B0373850L, 0x0C55C90FEL, 0x0DD0B83ACL, 0x0F792041DL, 0x01154760C4L, 0x01368D6223L,
            0x0174A9A8F7L, 0x01BF31FDF5L, 0x0218A263F3L, 0x0283F6118AL, 0x0304C0E1D9L, 0x039F4DDBD2L, 0x0458C3D496L,
            0x0537516580L, 0x064261AD01L, 0x0782DB9C67L, 0x09036DEEE2L, 0x0AD0EA51DCL, 0x0CFAB2C8A2L, 0x0F933CF0C3L,
            0x012B0AF8750L, 0x0166D9F6F2DL, 0x01AE9F2856AL, 0x0204BEFD34CL, 0x026C18630C1L, 0x02E81D43A82L,
            0x037CEFEAC9CL, 0x042F864CF21L, 0x0505D45C55BL, 0x0606FED533AL, 0x073B98330ACL, 0x08ADE9D6D9CL,
            0x0A6A4BCE9EEL, 0x0C7F8E2B251L, 0x0EFF7766F94L, 0x011FF5C152B2L, 0x01598D4E633CL, 0x018D62808BB8L,
            0x01C8FE13D3E0L, 0x020D8A96CD41L, 0x025C5F609F3DL, 0x02B70748B71FL, 0x031F48606C30L, 0x03972CD54937L,
            0x04210D287A98L, 0x04BF9BEE8CFBL, 0x055DA367298CL, 0x06103615DA77L, 0x06D9FFAD2CA0L, 0x07BE04C12081L,
            0x08BFAE551D0CL, 0x09E2D6EA6B10L, 0x0B2BD941366BL, 0x0C9FA10491F8L, 0x0E43BDA15306L, 0x0101E778FE57FL,
            0x011E460DFB99EL, 0x013DC38547EACL, 0x0160B7BF763A5L, 0x01878447B8FE2L, 0x01B295641794FL, 0x01E26343950E4L,
            0x0217734D93882L, 0x025259961C148L, 0x0293BA7B1A0C8L, 0x02DC4C6F0AFE8L, 0x032CD9F6233E5L,
            // is replaced
            0xFFFFFFFFFFFFFFFFL, 
            // fillers
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml, ml,
            ml, ml, ml, ml
    };
    static {
        for (int i = 150; i < 500; i++) {
            levelCaps[i] = (long) (levelCaps[i-1] * 1.11D);
        }
    }
    public static final transient int maxLevel = 500;
    
    public static int level = 0;
    public static int experience = 0;
    
    
    public static int topspeedPc(final Stat stat) {
        return (int) (((stat.swits[2] - 220) / 90.0F)*100f);
    }
        
    public static int acelfPc(final Stat stat) {
        return (int) ((stat.acelf[1] * stat.acelf[0] * stat.acelf[2] * stat.grip / 7700.0F)*100f);
    }
    
    public static int stuntsPc(final Stat stat) {
        return (int) (((stat.airc * stat.airs * stat.bounce + 28.0F) / 139.0F) * 100f);
    }
    
    public static int gripPc(final Stat stat) {
        return (int) ((stat.grip * 1.75f / 90f)*100f);
    }

    public static int strengthPc(final Stat stat) {
        return (int) (((stat.moment - 1f) * (8f * (stat.maxmag / 12800)) / 9f)*100f);
    }

    public static int xpDeathPenalty() {
        return (int) (levelCaps[level-1] * 0.00340499985d);
    }
}
