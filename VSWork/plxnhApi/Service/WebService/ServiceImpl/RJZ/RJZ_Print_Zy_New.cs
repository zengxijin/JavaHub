
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_Print_Zy_New : ServiceBase
    {
        public RJZ_Print_Zy_New()
        {
            this.sqlStr = "Print_Zy_New";
        }
        
        /// <summary>
        /// 打印住院补偿凭据
        /// </summary>
        /// <param name="SqlStr">Print_Zy_New</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_NO&D504_01

        // AREA_NO	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D504_01	VARCHAR2(24)	住院登记流水号


        // 0	成功
        // 1	失败  未找到该信息
        // 成功返回：
        // S_Returns=0;D504_01;D506_16;D506_25;D504_03;D504_08;IDENTITY;HZ_NAME;HZ_D401_01;D504_18;xb;D301_09;D504_28;D504_06;D101_02;ITEM_NAME;D504_09;DIAGNOSIS_NAME;BCLX;D504_11;D504_12;D504_13;D506_03;BEGINPAY;BZBL;BZHJ;BZHJ_DX;GRFD;D404_17;ZFYHJ;BCFYHJ;

        // D504_01	VARCHAR2(24)	住院登记流水号
        // D506_16	VARCHAR2(24)	补偿医疗机构
        // D506_25	DATE	补偿时间
        // D504_03	VARCHAR2(24)	患者姓名
        // D504_08	VARCHAR2(18)	合作医疗证号
        // IDENTITY	VARCHAR2(30)	个人属性
        // HZ_NAME	VARCHAR2(24)	户主姓名
        // HZ_D401_01	VARCHAR2(18)	户主身份证号
        // D504_18	VARCHAR2(24)	诊治医生
        // xb	VARCHAR2(24)	性别
        // D301_09	VARCHAR2(64)	家庭住址
        // D504_28	VARCHAR2(12)	联系电话
        // D504_06	VARCHAR2(3)	年龄
        // D101_02	VARCHAR2(64)	就医医疗机构
        // ITEM_NAME	VARCHAR2(64)	医院级别
        // D504_09	VARCHAR2(12)	住院号
        // DIAGNOSIS_NAME	VARCHAR2(80)	出院诊断
        // BCLX	VARCHAR2(64)	补偿类型
        // D504_11	DATE	入院时间
        // D504_12	DATE	出院时间
        // D504_13	NUMBER(3)	住院天数
        // D506_03	NUMBER(8,2)	总费用
        // BEGINPAY	NUMBER(8,2)	起付线
        // BZBL	NUMBER(3,2)	补偿比例
        // BZHJ	NUMBER(8,2)	补偿金额
        // BZHJ_DX	NUMBER(8,2)	补偿金额(大写)
        // GRFD	NUMBER(8,2)	自付金额
        // D404_17	NUMBER(2)	住院次数(本年累计补偿情况)
        // ZFYHJ	NUMBER(8,2)	医药费用(本年累计补偿情况)
        // BCFYHJ	VARCHAR2(8,2)	补偿金额(本年累计补偿情况)

    }
}
 