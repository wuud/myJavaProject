package wuziqi_1;

import java.util.ArrayList;

public class ruler {
	public static boolean blackWin(ArrayList<Integer> list) {
		for (int i = 1; i <= constant.h * constant.l; i++) {
			//如果同时出现横着的五个黑棋
			if (i % constant.h <= 10 && list.contains(i) && list.contains(i + 1) && list.contains(i + 2)
					&& list.contains(i + 3) && list.contains(i + 4))
				return true;
		    //如果同时出现竖着的五个黑棋
			if (i < (constant.h - 4) * constant.l && list.contains(i) && list.contains(i + constant.l)
					&& list.contains(i + constant.l * 2) && list.contains(i + constant.l * 3)
					&& list.contains(i + constant.l * 4))
				return true;
			//如果同时出现左倾斜的五个黑棋
			if (i % constant.h <= 10 && i < (constant.h - 4) * constant.l && list.contains(i)
					&& list.contains(i + constant.l + 1) && list.contains(i + (constant.l + 1) * 2)
					&& list.contains(i + (constant.l + 1) * 3) && list.contains(i + (constant.l + 1) * 4))
				return true;
			//如果同时出现右倾斜的五个黑棋
			if(i%constant.l>=5&&i < (constant.h - 4) * constant.l&&list.contains(i)
					&&list.contains(i+(constant.l - 1) * 1)&&list.contains(i+(constant.l - 1) * 2)
					&&list.contains(i+(constant.l - 1) * 3)&&list.contains(i+(constant.l - 1) * 4))
				return true;
		}
		return false;

	}
	public static boolean blueWin(ArrayList<Integer> list) {
		for (int i = 1; i <= constant.h * constant.l; i++) {
			//如果同时出现横着的五个蓝棋
			if (i % constant.h <= 10 && list.contains(i) && list.contains(i + 1) && list.contains(i + 2)
					&& list.contains(i + 3) && list.contains(i + 4))
				return true;
		    //如果同时出现竖着的五个蓝棋
			if (i < (constant.h - 4) * constant.l && list.contains(i) && list.contains(i + constant.l)
					&& list.contains(i + constant.l * 2) && list.contains(i + constant.l * 3)
					&& list.contains(i + constant.l * 4))
				return true;
			//如果同时出现左倾斜的五个蓝棋
			if (i % constant.h <= 10 && i < (constant.h - 4) * constant.l && list.contains(i)
					&& list.contains(i + constant.l + 1) && list.contains(i + (constant.l + 1) * 2)
					&& list.contains(i + (constant.l + 1) * 3) && list.contains(i + (constant.l + 1) * 4))
				return true;
			//如果同时出现右倾斜的五个蓝棋
			if(i%constant.l>=5&&i < (constant.h - 4) * constant.l&&list.contains(i)
					&&list.contains(i+(constant.l - 1) * 1)&&list.contains(i+(constant.l - 1) * 2)
					&&list.contains(i+(constant.l - 1) * 3)&&list.contains(i+(constant.l - 1) * 4))
				return true;
		}
		return false;

	}
}
