using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService
{
    public interface IService
    {
        /// <summary>
        /// 接口服务
        /// </summary>
        /// <param name="Sql_Str">过程名称</param>
        /// <param name="parames">参数列表，以分隔符连接</param>
        /// <param name="split">参数解析的分隔符</param>
        /// <returns></returns>
        string executeSql(string SqlStr, string parames, string split);

        /// <summary>
        /// 接口服务
        /// </summary>
        /// <param name="Sql_Str">过程名称</param>
        /// <param name="parames">封装为Dictionary的参数，自动组装为请求字符串</param>
        /// <param name="split">参数解析的分隔符</param>
        /// <returns></returns>
        string executeSql(string SqlStr, Dictionary<string, string> paramesDict, string split);

        /// <summary>
        /// 返回原始执行后的报文
        /// </summary>
        /// <returns></returns>
        string getExecuteResultPlainString();

        /// <summary>
        /// 返回封装为Dictionary的请求参数
        /// </summary>
        /// <returns>返回key-value形式的Dictionary，方便获取参数</returns>
        Dictionary<string, string> getRequestParamWrapperMap();

        /// <summary>
        /// 返回封装为Dictionary的调用结果
        /// </summary>
        /// <returns>返回key-value形式的Dictionary，方便获取参数</returns>
        Dictionary<string, string> getResponseResultWrapperMap();

        /// <summary>
        /// 返回接口执行的状态
        /// </summary>
        /// <returns>成功true，失败false</returns>
        bool getExecuteStatus();
    }
}
