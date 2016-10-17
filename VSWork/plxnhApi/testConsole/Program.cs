using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Service.WebService;
using Service.WebService.ServiceImpl.login;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace testConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            
            json();
            //hhh();
        }


        public static void json()
        {
            string S_Returns = "0;USER_ID;USER_CODE;USER_PASS;USER_NAME;DEP_ID;USER_TEL;DEP_NAME;DEP_AREA;USER_JG;DEP_LEVEL;AREA_CODE;T_IS_FLASH_AUTHORIZED;T_YEARS;T_IS_SK;T_IS_SK_HOSP;T_IS_XJ;T_RJZ_DATE;T_CH_START_DATE;T_CH_END_DATE;T_DY_MX_IS_HZ;T_IS_BLUSH_DAY;T_BLUSH_DAY;";
            string[] ss = S_Returns.Split(new string[] { ";" }, StringSplitOptions.None);

            Dictionary<string, int> dd = hhh();

            Dictionary<string, string> kk = new Dictionary<string, string>();

            foreach (KeyValuePair<string, int> pair in dd)
            {
                if (ss.Length > pair.Value)
                {
                    kk.Add(pair.Key,ss[pair.Value]);
                }
            }
        }

        public static Dictionary<string, int> hhh()
        {
            //string jsonText = "{\"beijing\":{\"zone\":\"海淀\",\"zone_en\":\"haidian\"}}";
            //JObject jo = (JObject)JsonConvert.DeserializeObject(jsonText);
            //string zone = jo["beijing"]["zone"].ToString();
            //string zone_en = jo["beijing"]["zone_en"].ToString();

            //Console.WriteLine(zone);

            StringBuilder sb = new StringBuilder();
            using (StreamReader sr = new StreamReader(@"D:\GitHub\JavaHub\VSWork\plxnhApi\Service\paramParse.json", Encoding.Default))
            {

                while (!sr.EndOfStream)
                {
                    string line = sr.ReadLine().Trim();
                    sb.Append(line);
                }
            }

            string json = sb.ToString();
            JObject jo = (JObject)JsonConvert.DeserializeObject(json);
            string ss = jo["PROC_CHECK_USER"]["callService"]["service"].ToString();
            //string zone = jo["PROC_CHECK_USER"]["input"]["USER_CODE"].ToString();
            Dictionary<string, int> dic = new Dictionary<string, int>();
            JObject tokenList = (JObject)jo["PROC_CHECK_USER"]["response"];
            foreach (JProperty jp in tokenList.Properties())
            {
                string key = jp.Name;
                string val = jp.Value.ToString();
                dic.Remove(key);
                dic.Add(key, int.Parse(val));
            }

            return dic;
            //foreach (var item in xx)
            //{
            //    Console.WriteLine(item);
            //    item.
            //}
        }

        public static void loginTest()
        {
            IService service = new LoginAuth();

            //直接塞参数进入Dictionary，由框架自动组装顺序
            Dictionary<string, string> requestParam = new Dictionary<string, string>();
            requestParam.Add("USER_CODE", "123456");
            requestParam.Add("USER_PASS", "xxxxx");

            //使用executeSql重载的Dictionary参数方法
            string response = service.executeSql("", requestParam, "&");
            Dictionary<string, string> responseDict = service.getResponseResultWrapperMap();

            //通过Dictionary直接获取值
            string USER_ID   = responseDict["USER_ID"];
            string USER_CODE = responseDict["USER_CODE"]; 
            //...

        }
    }
}
