
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_getShisuanResult : ServiceBase
    {
        public RJZ_getShisuanResult()
        {
            this.sqlStr = "getShisuanResult";
        }
        
        /// <summary>
        /// 试算
        /// </summary>
        /// <param name="SqlStr">getShisuanResult</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // D505_02&COME_AREA&AREA_CODE&D504_07&D504_02&D504_14&D504_21&D504_11&D506_15&D504_15&D504_06&D504_10&D504_12&D504_29&D504_16_D&D504_16_T&S701_01

        // D505_02 VARCHAR2(24)	登记流水号
        // COME_AREA VARCHAR2(6)	地区代码(支付单位)
        // AREA_CODE	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D504_07 VARCHAR2(16)	家庭编号
        // D504_02 VARCHAR2(2)	成员序号
        // D504_14 VARCHAR2(22)	就医机构
        // D504_21	VARCHAR2(40)	入院诊断(疾病代码)
        // D504_11	DATE	就诊日期(入院时间) (格式为YYYY-MM-DD)
        // D506_15 VARCHAR2(3)	补偿类别代码
        // D504_15 CHAR(1)	就医机构级别(相关数据代码标准:S201-06)
        // D504_06 VARCHAR2(3)	年龄
        // D504_10	CHAR(1)	就诊类型(相关数据代码标准:S301-05)
        // D504_12	DATE	出院时间(格式为YYYY-MM-DD)
        // D504_29	VARCHAR2(40)	出院诊断（疾病代码）
        // D504_16_D	VARCHAR2(4)	入院科室(相关数据代码标准:S201-03)
        // D504_16_T	VARCHAR2(4)	出院科室(相关数据代码标准:S201-03)
        // S701_01	CHAR(1)	是否是中途结算(相关数据代码标准:S701-01)

        // 0	成功
        // 1	程序异常
        // 试算成功：
        // S_Returns=0;TOTAL_COSTS;ZF_COSTS;TOTAL_CHAGE;D506_23;D506_18;BEGINPAY;SCALE;HEAV_REDEEM_SUM;REDEEM_TOTAL    (分号分隔)



        // TOTAL_COSTS	NUMBER(8,2)	总费用
        // ZF_COSTS	NUMBER(8,2)	自费费用
        // TOTAL_CHAGE	NUMBER(8,2)	合理费用
        // D506_23	NUMBER(8,2)	实际补偿金额
        // D506_18	NUMBER(8,2)	核算补偿金额(实际补偿合计额)
        // BEGINPAY	NUMBER(8,2)	本次起伏线
        // SCALE	NUMBER(3,2)	报销比例
        // HEAV_REDEEM_SUM	NUMBER(8,2)	大病支付额
        // REDEEM_TOTAL	NUMBER(8,2)	单次补偿合计
        // 试算失败：S_Returns= 1;错误信息    (分号分隔)




    }
}
 