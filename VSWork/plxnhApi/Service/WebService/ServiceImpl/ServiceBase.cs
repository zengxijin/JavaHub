using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl
{
    public class ServiceBase : IService
    {
        private string _sqlStr;
        /// <summary>
        /// 执行的服务标识
        /// </summary>
        public string sqlStr
        {
            get
            {
                return _sqlStr;
            }
            set
            {
                _sqlStr = value;
            }
        }
        
        private string _parames;
        /// <summary>
        /// 请求参数
        /// </summary>
        public string parames
        {
            get
            {
                return _parames;
            }
            set
            {
                _parames = value;
            }
        }

        private string _split = "&";
        /// <summary>
        /// 请求参数的分隔符，默认为&
        /// </summary>
        public string split
        {
            get
            {
                return _split;
            }
            set
            {
                _split = value;
            }
        }

        private string _resultSplit = ";";
        /// <summary>
        /// 返回结果的分隔符，目前默认是分号;符号
        /// </summary>
        public string resultSplit
        {
            get
            {
                return _resultSplit;
            }
            set
            {
                _resultSplit = value;
            }
        }

        private string _executeResult;
        /// <summary>
        /// 执行结果
        /// </summary>
        public string executeResult
        {
            get
            {
                return _executeResult;
            }
            set
            {
                _executeResult = value;
            }
        }
        
        /// <summary>
        /// 这个是每个服务调用的最终出口
        /// </summary>
        /// <param name="SqlStr">过程名称</param>
        /// <param name="parames">字符串拼接的参数</param>
        /// <param name="split">参数的分隔符</param>
        /// <returns></returns>
        public string executeSql(string SqlStr, string parames, string split)
        {
            if (!string.IsNullOrEmpty(SqlStr)) this.sqlStr = SqlStr;

            this.parames = parames;
            this.split   = split;

            //根据配置文件决定调用哪个接口
            string callService = ConfigUtil.getConfigService(this.sqlStr);

            if (callService == "Update_Data_String")
            {
                return this.executeResult = ServiceInvoke.Update_Data_String(this.sqlStr, parames, split);
            }

            if (callService == "Execute_Sql")
            {
                return this.executeResult = ServiceInvoke.Execute_Sql(this.sqlStr, parames, split);
            }

            return "";
            
        }

        /// <summary>
        /// 参数通过Dictionary传递，参数组装顺序在配置文件paramParse.json
        /// 使用者无需关心参数的拼接顺序，直接使用Dictionary往里塞数据即可
        /// </summary>
        /// <param name="SqlStr">过程名称</param>
        /// <param name="paramesDict">参数的Dictionary封装</param>
        /// <param name="split">参数分割符</param>
        /// <returns></returns>
        public string executeSql(string SqlStr, Dictionary<string,string> paramesDict, string split)
        {
            if (!string.IsNullOrEmpty(SqlStr)) this.sqlStr = SqlStr;

            Dictionary<string, int> configDict = ConfigUtil.getRequestParamConfig(this.sqlStr);
            
            //根据配置的下标升序排列，防止配置文件配置乱序
            Dictionary<string, int> dictSortedByValueIndex = configDict.OrderBy(p => p.Value).ToDictionary(p => p.Key, o => o.Value);

            string plainParams = "";
            //根据配置的下标顺序组装请求参数
            foreach (KeyValuePair<string, int> pair in dictSortedByValueIndex)
            {
                if (paramesDict.ContainsKey(pair.Key))
                {
                    plainParams += paramesDict[pair.Key] + split;
                }
                else
                {
                    plainParams += "" + split;
                }
            }

            //去掉最后一个分隔符
            if (plainParams != "" && plainParams.Length > split.Length)
            {
                this.parames = plainParams.Substring(0, plainParams.Length - split.Length);
            }

            return this.executeSql(this.sqlStr, this.parames, split);
        }

        /// <summary>
        /// 返回接口执行后的字符串结果
        /// </summary>
        /// <returns></returns>
        public string getExecuteResultPlainString()
        {
            return this.executeResult;
        }
        
        /// <summary>
        /// 将接口文档中的所有请求的参数封装成Dictionary键值对，
        /// 方便使用，无需调用方记住请求参数的顺序
        /// 并且键值对的取数规则通过paramParse.json配置，如果业务有变化，通过修改此配置文件即可
        /// </summary>
        /// <returns></returns>
        public Dictionary<string, string> getRequestParamWrapperMap()
        {
            Dictionary<string, string> retDict = new Dictionary<string, string>();

            Dictionary<string, int> configDict = new Dictionary<string, int>();
            configDict = ConfigUtil.getRequestParamConfig(this.sqlStr);

            string[] requestArray = this.executeResult.Split(new string[] { this.split }, StringSplitOptions.None);

            foreach (KeyValuePair<string, int> pair in configDict)
            {
                if (requestArray.Length > pair.Value)
                {
                    retDict.Add(pair.Key, requestArray[pair.Value]);
                }
                else
                {
                    retDict.Add(pair.Key, "");
                }
            }

            return retDict;
        }

        /// <summary>
        /// 将接口文档中的所有返回结果的参数封装成Dictionary键值对，
        /// 方便使用，无需调用方记住返回结果的顺序
        /// 并且键值对的取数规则通过paramParse.json配置，如果业务有变化，通过修改此配置文件即可
        /// </summary>
        /// <returns>Dictionary键值对</returns>
        public Dictionary<string, string> getResponseResultWrapperMap()
        {
            Dictionary<string, string> retDict = new Dictionary<string, string>();

            Dictionary<string, int> configDict = new Dictionary<string, int>();
            configDict = ConfigUtil.getResponseParamConfig(this.sqlStr);

            string[] responseArray = this.executeResult.Split(new string[] { this.resultSplit }, StringSplitOptions.None);

            foreach (KeyValuePair<string, int> pair in configDict)
            {
                if (responseArray.Length > pair.Value)
                {
                    retDict.Add(pair.Key, responseArray[pair.Value]);
                }
                else
                {
                    retDict.Add(pair.Key, "");
                }
            }

            return retDict;
        }
        
        /// <summary>
        /// 根据接口文档的描述，返回结果第一个字符为0即为成功
        /// 默认实现，其他业务场景可以改写此方法
        /// </summary>
        /// <returns></returns>
        public bool getExecuteStatus()
        {
            if (string.IsNullOrEmpty(executeResult) == false)
            {
                if (executeResult.Substring(0, 1) == "0")
                    return true;
            }

            return false;
        }
    }
}
