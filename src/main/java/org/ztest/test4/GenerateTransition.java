package org.ztest.test4;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lichaojie on 2017/2/17.
 */
public class GenerateTransition {

    public static void main(String[] args){

        Long m = 1l;
        for(int i = 1 ; i < 100 ; i ++){
            m *= 2;
            System.out.println("i:" + i + "-" + m);
        }

        boolean a232,a234,a236,a238,a240,a242,a244,a246,a248,a250,a252,a254,a256,a258,a260,a262,a264,a266,a268,a270,a272,a274,a276,a278,a280,a282,a284,a286,a288,a290,a292,a294,a296,a298,a300,a302,a304,a306,a308,a310,a312,a314,a316,a318,a320,a322,a324,a326,a328,a330,a332,a334,a336,a338,a340,a342,a344,a346,a348,a350,a352,a354,a356,a358,a360,a362,a364,a366,a368,a370,a372,a374,a376,a378,a380,a382,a384,a386,a388,a390,a392,a394,a396,a398,a400,a402,a404,a406,a408,a410,a412,a414,a416,a418,a420,a422,a424,a426,a428,a430,a432,a434,a436,a438,a440,a442,a444,a446,a448,a450,a452,a454,a456,a458,a460,a462,a464,a466,a468,a470,a472,a474,a476,a478,a480,a482,a484,a486,a488,a490,a492,a494,a496,a498,a500,a502,a504,a506,a508,a510,a512,a514,a516,a518,a520,a522,a524,a526,a528,a530,a532,a534,a536,a538,a540,a542,a544,a546,a548,a550,a552,a554,a556,a558,a560,a562,a564,a566,a568,a570,a572,a574,a576,a578,a580,a582,a584,a586,a588,a590,a592,a594,a596,a598,a600,a602,a604,a606,a608,a610,a612,a614,a616,a618,a620,a622,a624,a626,a628,a630,a632,a634,a636,a638,a640,a642,a644,a646,a648,a650,a652,a654,a656,a658,a660,a662,a664,a666,a668,a670,a672,a674,a676,a678,a680,a682,a684,a686,a688,a690,a692,a694,a696,a698,a700,a702,a704,a706,a708,a710,a712,a714,a716,a718,a720,a722,a724,a726,a728,a730,a732,a734,a736,a738,a740,a742,a744,a746,a748,a750,a752,a754,a756,a758;
        boolean[] latches = new boolean[62];
        Node[] inputs = new Node[54];

        for(int i = 0 ; i < latches.length ; i ++){
            latches[i] = false;
        }

        for(int i =0 ;i < inputs.length; i ++){
            inputs[i] = new Node();
        }

        a232 = latches[7] && latches[2];
        a234 = !a232 && inputs[0].getValue();
        a236 = !latches[1] && !inputs[0].getValue();
        a238 = !a236 && !a234;
        a240 = !latches[3] && inputs[1].getValue();
        a242 = !latches[2] && !inputs[1].getValue();
        a244 = !a242 && !a240;
        a246 = !latches[5] && !latches[3];
        a248 = latches[5] && latches[3];
        a250 = !a248 && !a246;
        a252 = !a250 && !a244;
        a254 = a250 && !latches[2];
        a256 = !a254 && !a252;
        a258 = !latches[3] && !inputs[2].getValue();
        a260 = !latches[17] && latches[4];
        a262 = !a260 && inputs[2].getValue();
        a264 = !a262 && !a258;
        a266 = !latches[55] && !latches[4];
        a268 = latches[55] && !latches[51];
        a270 = !a268 && !a266;
        a272 = !latches[18] && latches[6];
        a274 = !a272 && inputs[4].getValue();
        a276 = !latches[5] && !inputs[4].getValue();
        a278 = !a276 && !a274;
        a280 = !latches[11]&& inputs[5].getValue();
        a282 = !latches[6] && !inputs[5].getValue();
        a284 = !a282 && !a280;
        a286 = !latches[18]&& !latches[11];
        a288 = latches[18] && latches[11];
        a290 = !a288 && !a286;
        a292 = !a290 && !a284;
        a294 = a290 && !latches[6];
        a296 = !a294 && !a292;
        a298 = !latches[7] && !inputs[6].getValue();
        a300 = latches[16] && !latches[12];
        a302 = !a300 && inputs[6].getValue();
        a304 = !a302 && !a298;
        a306 = !latches[8] && !inputs[7].getValue();
        a308 = latches[17] && inputs[7].getValue();
        a310 = !a308 && !a306;
        a312 = latches[56] && !latches[8];
        a314 = !latches[56] && !latches[9];
        a316 = !a314 && !a312;
        a318 = !latches[10] && !inputs[9].getValue();
        a320 = latches[9] && !latches[1];
        a322 = !a320 && inputs[9].getValue();
        a324 = !a322 && !a318;
        a326 = !latches[10] && !latches[3];
        a328 = a326 && inputs[10].getValue();
        a330 = !latches[11] && !inputs[10].getValue();
        a332 = !a330 && !a328;
        a334 = !latches[10] && inputs[11].getValue();
        a336 = !latches[12] && !inputs[11].getValue();
        a338 = !a336 && !a334;
        a340 = !latches[10] && !latches[5];
        a342 = latches[10]&& latches[5];
        a344 = !a342 && !a340;
        a346 = !a344 && !a338;
        a348 = a344 && !latches[12];
        a350 = !a348 && !a346;
        a352 = latches[11] && !latches[6];
        a354 = !a352 && inputs[12].getValue();
        a356 = !latches[13] && !inputs[12].getValue();
        a358 = !a356 && !a354;
        a360 = !latches[14] && !inputs[13].getValue();
        a362 = !latches[16] && latches[13];
        a364 = !a362 && inputs[13].getValue();
        a366 = !a364 && !a360;
        a368 = latches[13] && latches[7];
        a370 = !a368 && inputs[14].getValue();
        a372 = !latches[15] && !inputs[14].getValue();
        a374 = !a372 && !a370;
        a376 = !latches[7] && !latches[2];
        a378 = !a376 && inputs[15].getValue();
        a380 = latches[16] && !inputs[15].getValue();
        a382 = !a380 && !a378;
        a384 = !latches[17] && !inputs[16].getValue();
        a386 = !latches[16] && latches[12];
        a388 = !a386 && inputs[16].getValue();
        a390 = !a388 && !a384;
        a392 = !latches[18] && !inputs[17].getValue();
        a394 = !latches[19] && !latches[14];
        a396 = a394 && inputs[17].getValue();
        a398 = !a396 && !a392;
        a400 = !latches[19] && !inputs[18].getValue();
        a402 = !latches[25] && latches[20];
        a404 = !a402 && inputs[18].getValue();
        a406 = !a404 && !a400;
        a408 = !latches[21] && inputs[19].getValue();
        a410 = !latches[20] && !inputs[19].getValue();
        a412 = !a410 && !a408;
        a414 = !latches[23] && !latches[21];
        a416 = latches[23] && latches[21];
        a418 = !a416 && !a414;
        a420 = !a418 && !a412;
        a422 = a418 && !latches[20];
        a424 = !a422 && !a420;
        a426 = !latches[21] && !inputs[20].getValue();
        a428 = !latches[35] && latches[22];
        a430 = !a428 && inputs[20].getValue();
        a432 = !a430 && !a426;
        a434 = !latches[57] && !latches[22];
        a436 = latches[57] && !latches[15];
        a438 = !a436 && !a434;
        a440 = !latches[36] && latches[24];
        a442 = !a440 && inputs[22].getValue();
        a444 = !latches[23] && !inputs[22].getValue();
        a446 = !a444 && !a442;
        a448 = !latches[29] && inputs[23].getValue();
        a450 = !latches[24]&& !inputs[23].getValue();
        a452 = !a450 && !a448;
        a454 = !latches[36] && !latches[29];
        a456 = latches[36] && latches[29];
        a458 = !a456 && !a454;
        a460 = !a458 && !a452;
        a462 = a458 && !latches[24];
        a464 = !a462 && !a460;
        a466 = !latches[34] && !latches[30];
        a468 = !a466 && inputs[24].getValue();
        a470 = latches[25] && !inputs[24].getValue();
        a472 = !a470 && !a468;
        a474 = !latches[26] && !inputs[25].getValue();
        a476 = latches[35] && inputs[25].getValue();
        a478 = !a476 && !a474;
        a480 = latches[58] && !latches[26];
        a482 = !latches[58] && !latches[27];
        a484 = !a482 && !a480;
        a486 = !latches[28] && !inputs[27].getValue();
        a488 = latches[27] && !latches[19];
        a490 = !a488 && inputs[27].getValue();
        a492 = !a490 && !a486;
        a494 = !latches[28] && !latches[21];
        a496 = a494 && inputs[28].getValue();
        a498 = !latches[29] && !inputs[28].getValue();
        a500 = !a498 && !a496;
        a502 = !latches[28] && inputs[29].getValue();
        a504 = !latches[30] && !inputs[29].getValue();
        a506 = !a504 && !a502;
        a508 = !latches[28] && !latches[23];
        a510 = latches[28] && latches[23];
        a512 = !a510 && !a508;
        a514 = !a512 && !a506;
        a516 = a512 && !latches[30];
        a518 = !a516 && !a514;
        a520 = latches[29] && !latches[24];
        a522 = !a520 && inputs[30].getValue();
        a524 = !latches[31] && !inputs[30].getValue();
        a526 = !a524 && !a522;
        a528 = latches[34] && latches[31];
        a530 = !a528 && inputs[31].getValue();
        a532 = !latches[32] && !inputs[31].getValue();
        a534 = !a532 && !a530;
        a536 = !latches[33] && !inputs[32].getValue();
        a538 = latches[31] && !latches[25];
        a540 = !a538 && inputs[32].getValue();
        a542 = !a540 && !a536;
        a544 = !latches[34] && !inputs[33].getValue();
        a546 = latches[25] && !latches[20];
        a548 = !a546 && inputs[33].getValue();
        a550 = !a548 && !a544;
        a552 = latches[34] && latches[30];
        a554 = !a552 && inputs[34].getValue();
        a556 = !latches[35] && !inputs[34].getValue();
        a558 = !a556 && !a554;
        a560 = !latches[36] && !inputs[35].getValue();
        a562 = !latches[37] && !latches[32];
        a564 = a562 && inputs[35].getValue();
        a566 = !a564 && !a560;
        a568 = !latches[37]&& !inputs[36].getValue();
        a570 = !latches[43] && latches[38];
        a572 = !a570 && inputs[36].getValue();
        a574 = !a572 && !a568;
        a576 = !latches[39] && inputs[37].getValue();
        a578 = !latches[38] && !inputs[37].getValue();
        a580 = !a578 && !a576;
        a582 = !latches[41] && !latches[39];
        a584 = latches[41] && latches[39];
        a586 = !a584 && !a582;
        a588 = !a586 && !a580;
        a590 = a586 && !latches[38];
        a592 = !a590 && !a588;
        a594 = !latches[39] && !inputs[38].getValue();
        a596 = !latches[53] && latches[40];
        a598 = !a596 && inputs[38].getValue();
        a600 = !a598 && !a594;
        a602 = !latches[59] && !latches[40];
        a604 = latches[59] && !latches[33];
        a606 = !a604 && !a602;
        a608 = !latches[54] && latches[42];
        a610 = !a608 && inputs[40].getValue();
        a612 = !latches[41] && !inputs[40].getValue();
        a614 = !a612 && !a610;
        a616 = !latches[47] && inputs[41].getValue();
        a618 = !latches[42] && !inputs[41].getValue();
        a620 = !a618 && !a616;
        a622 = !latches[54] && !latches[47];
        a624 = latches[54] && latches[47];
        a626 = !a624 && !a622;
        a628 = !a626 && !a620;
        a630 = a626 && !latches[42];
        a632 = !a630 && !a628;
        a634 = !latches[52] && !latches[48];
        a636 = !a634 && inputs[42].getValue();
        a638 = latches[43] && !inputs[42].getValue();
        a640 = !a638 && !a636;
        a642 = !latches[44] && !inputs[43].getValue();
        a644 = latches[53] && inputs[43].getValue();
        a646 = !a644 && !a642;
        a648 = latches[60] && !latches[44];
        a650 = !latches[60] && !latches[45];
        a652 = !a650 && !a648;
        a654 = !latches[46] && !inputs[45].getValue();
        a656 = latches[45] && !latches[37];
        a658 = !a656 && inputs[45].getValue();
        a660 = !a658 && !a654;
        a662 = !latches[46] && !latches[39];
        a664 = a662 && inputs[46].getValue();
        a666 = !latches[47] && !inputs[46].getValue();
        a668 = !a666 && !a664;
        a670 = !latches[46] && inputs[47].getValue();
        a672 = !latches[48] && !inputs[47].getValue();
        a674 = !a672 && !a670;
        a676 = !latches[46] && !latches[41];
        a678 = latches[46] && latches[41];
        a680 = !a678 && !a676;
        a682 = !a680 && !a674;
        a684 = a680 && !latches[48];
        a686 = !a684 && !a682;
        a688 = latches[47] && !latches[42];
        a690 = !a688 && inputs[48].getValue();
        a692 = !latches[49] && !inputs[48].getValue();
        a694 = !a692 && !a690;
        a696 = latches[52] && latches[49];
        a698 = !a696 && inputs[49].getValue();
        a700 = !latches[50] && !inputs[49].getValue();
        a702 = !a700 && !a698;
        a704 = !latches[51] && !inputs[50].getValue();
        a706 = latches[49] && !latches[43];
        a708 = !a706 && inputs[50].getValue();
        a710 = !a708 && !a704;
        a712 = !latches[52] && !inputs[51].getValue();
        a714 = latches[43] && !latches[38];
        a716 = !a714 && inputs[51].getValue();
        a718 = !a716 && !a712;
        a720 = latches[52] && latches[48];
        a722 = !a720 && inputs[52].getValue();
        a724 = !latches[53] && !inputs[52].getValue();
        a726 = !a724 && !a722;
        a728 = !latches[54] && !inputs[53].getValue();
        a730 = !latches[50] && !latches[1];
        a732 = a730 && inputs[53].getValue();
        a734 = !a732 && !a728;
        a736 = a652 && a606;
        a738 = a484 && a438;
        a740 = a316 && a270;
        a742 = !a740 && !a738;
        a744 = a742 && !a736;
        a746 = a744 && !latches[61];
        a748 = latches[53] && latches[35];
        a750 = latches[53] && latches[17];
        a752 = latches[35] && latches[17];
        a754 = !a752 && !a750;
        a756 = a754 && !a748;
        a758 = !a756 && !latches[61];

        List<String> stateList = new ArrayList<String>();

        int flag = 0;
        int index = 0;
        while (true){
            String str = "{";
            for(int i = 1 ; i < latches.length ; i ++){
                str += latches[i]?1:0;
                str += ",";
            }
            str += (a758?1:0);
            str += "}";

            //System.out.print("str1:" + str);

            if(stateList.contains(str)){
                flag ++;
                if(flag > 1){
                    int tempInt = stateList.indexOf(str);
                    if(tempInt == 0 || tempInt == 1) break;
                    str = stateList.get(stateList.indexOf(str)==0?0:stateList.indexOf(str) - 2);
                    flag = 0;
                }else{
                    str = stateList.get(stateList.indexOf(str)==0?0:stateList.indexOf(str) - 1);
                }
                for(int i = 1; i < latches.length ; i ++){
                    latches[i] = Integer.parseInt(str.charAt(i * 2 - 1) + "") == 1?true:false;
                }
            }else {
                stateList.add(str);
                System.out.println("str" + ++index + ":" + str);
                try{
                    FileWriter writer = new FileWriter("E:\\Java\\Code\\transition.txt",true);
                    writer.write(str);
                    writer.write("\r\n");
                    writer.close();
                }catch (Exception e){
                    System.out.println("IOException !!");
                }
            }

            //System.out.println("  str2:" + str);

            if(Integer.parseInt(str.charAt(str.length() - 2) + "") == 1) break;

            {
                latches[1] = a238;//计算所有latches的下一状态
                latches[2] = a256;
                latches[3] = a264;
                latches[4] = a270;
                latches[5] = a278;
                latches[6] = a296;
                latches[7] = a304;
                latches[8] = a310;
                latches[9] = a316;
                latches[10] = a324;
                latches[11] = a332;
                latches[12] = a350;
                latches[13] = a358;
                latches[14] = a366;
                latches[15] = a374;
                latches[16] = !a382;
                latches[17] = a390;
                latches[18] = a398;
                latches[19] = a406;
                latches[20] = a424;
                latches[21] = a432;
                latches[22] = a438;
                latches[23] = a446;
                latches[24] = a464;
                latches[25] = !a472;
                latches[26] = a478;
                latches[27] = a484;
                latches[28] = a492;
                latches[29] = a500;
                latches[30] = a518;
                latches[31] = a526;
                latches[32] = a534;
                latches[33] = a542;
                latches[34] = a550;
                latches[35] = a558;
                latches[36] = a566;
                latches[37] = a574;
                latches[38] = a592;
                latches[39] = a600;
                latches[40] = a606;
                latches[41] = a614;
                latches[42] = a632;
                latches[43] = !a640;
                latches[44] = a646;
                latches[45] = a652;
                latches[46] = a660;
                latches[47] = a668;
                latches[48] = a686;
                latches[49] = a694;
                latches[50] = a702;
                latches[51] = a710;
                latches[52] = a718;
                latches[53] = a726;
                latches[54] = a734;
                latches[55] = inputs[3].getValue();
                latches[56] = inputs[8].getValue();
                latches[57] = inputs[21].getValue();
                latches[58] = inputs[26].getValue();
                latches[59] = inputs[39].getValue();
                latches[60] = inputs[44].getValue();
                latches[61] = !a746;
            }
        }

    }

}
