
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_shoufei : ServiceBase
    {
        public RJZ_shoufei()
        {
            this.sqlStr = "shoufei";
        }
        
        /// <summary>
        /// 收费
        /// </summary>
        /// <param name="SqlStr">shoufei</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_CODE&D504_01&D504_12&D504_15&D504_17&D504_18&D504_20&D504_22&D506_03&D506_13&D506_18&D506_15&D506_14&D506_16&D506_17&D506_23&D506_26&D506_27&SELF_PAY&HEAV_REDEEM_SUM&BEGINPAY&D504_29

        // AREA_CODE	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D504_01 VARCHAR2(24)	住院登记流水号
        // D504_12	DATE	出院时间(格式为YYYY-MM-DD)
        // D504_15 CHAR(1)	就医机构级别(相关数据代码标准:S201-06)
        // D504_17	VARCHAR2(4)	出院科室(相关数据代码标准:S201-03)
        // D504_18	VARCHAR2(24)	经治医生
        // D504_20	CHAR(1)	出院状态(相关数据代码标准:S301-03)
        // D504_22	VARCHAR2(40)	并发症(为空时传’NULL’)
        // D506_03 NUMBER(8,2)	总费用（TOTAL_COSTS 总费用）试算得到
        // D506_13 NUMBER(8,2)	可补偿住院医药费（TOTAL_CHAGE 合理费用）试算得到
        // D506_18 NUMBER(8,2)	核算补偿金额（D506_18  核算补偿金额(实际补偿合计额)）试算得到
        // D506_15 VARCHAR2(3)	补偿类别代码
        // D506_14	CHAR(1)	补偿账户类别(相关数据代码标准:S301-09)
        // D506_16 VARCHAR2(24)	核算机构(代码)
        // D506_17	VARCHAR2(24)	核算人
        // D506_23 NUMBER(8,2)	实际补偿额（D506_23   实际补偿金额）试算得到
        // D506_26	VARCHAR2(24)	付款人
        // D506_27	CHAR(1)	中途结算标志(相关数据代码标准:S701-01)
        // SELF_PAY NUMBER(8,2)	自费金额（ZF_COSTS  自费费用）试算得到
        // HEAV_REDEEM_SUM NUMBER(8,2)	大病支付金额（HEAV_REDEEM_SUM  大病支付额）试算得到
        // BEGINPAY NUMBER(8,2)	本次起付额（BEGINPAY   本次起伏线）试算得到
        // D504_29	VARCHAR2(40)	出院诊断(疾病代码)



        // 0	成功
        // 1	程序异常
        // 收费成功：S_Returns= 0
        // 收费失败：S_Returns= 1;错误信息   (分号分隔)




    }
}
 