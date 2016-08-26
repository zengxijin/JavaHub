support to using the pattern like root.node1.node2 to get JSONObject or JSONArray
when you need to operate some complex json data

## json node fast access ##

`json` format data is become popular for data exchange,and we parse and extract data using the `fastjson` which is mantained by [alibaba](https://github.com/alibaba/fastjson).

Example

    {
      "name":"jackZeng",
      "address":{
			"country":"China",
			"province":"Shanghai",
			"dist":"Pudong"
		  },
  	  "skills":[
  			{"java":"excellent"},
  			{"oracle":"good"}
  		]
    }

Usually 
