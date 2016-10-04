using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
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
            //string jsonText = "{\"beijing\":{\"zone\":\"海淀\",\"zone_en\":\"haidian\"}}";
            //JObject jo = (JObject)JsonConvert.DeserializeObject(jsonText);
            //string zone = jo["beijing"]["zone"].ToString();
            //string zone_en = jo["beijing"]["zone_en"].ToString();

            //Console.WriteLine(zone);

            StringBuilder sb = new StringBuilder();
            using (StreamReader sr = new StreamReader("paramParse.json", Encoding.Default))
            {
                
                while(!sr.EndOfStream)
                {
                    string line = sr.ReadLine().Trim();
                    sb.Append(line);
                }
            }

            string json = sb.ToString();
            JObject jo = (JObject)JsonConvert.DeserializeObject(json);
            string zone = jo["PROC_CHECK_USER"]["input"]["USER_CODE"].ToString();
            JObject tokenList = (JObject)jo["PROC_CHECK_USER"]["input"];
            foreach (JProperty jp in tokenList.Properties())
            {
               

                    string key = jp.Name;
                    string val = jp.Value.ToString();

            }
            
            //foreach (var item in xx)
            //{
            //    Console.WriteLine(item);
            //    item.
            //}
        }
    }
}
