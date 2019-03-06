define({ "api": [
  {
    "type": "Post",
    "url": "/api/user/addUser",
    "title": "注册用户 api",
    "name": "addUser",
    "group": "UserController",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>登录名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>登陆密码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "userNumber",
            "description": "<p>用户编码</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "age",
            "description": "<p>年龄</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>姓名</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数:",
          "content": "{\n    \"userNumber\" : \"865533614\",\n    \"age\" : \"24\",\n    \"name\": \"张照威\",\n    \"username\":\"admin\",\n    \"password\":\"000000\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "1",
            "description": "<p>变更行数</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功返回值:",
          "content": "{\n    \"id\": null,\n    \"datalag\": 0,\n    \"versionNumber\": 0,\n    \"createdDate\": null,\n    \"createdBy\": 0,\n    \"lastUpdatedDate\": null,\n    \"lastUpdatedBy\": 0,\n    \"userNumber\": 865533614,\n    \"username\": \"admin\",\n    \"password\": \"000000\",\n    \"name\": \"张照威\",\n    \"age\": 24\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/zzw/usermanage/controller/UserController.java",
    "groupTitle": "用户控制器"
  },
  {
    "type": "Post",
    "url": "/api/user/login",
    "title": "登陆 api",
    "name": "login",
    "group": "UserController",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>登录名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>登陆密码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数:",
          "content": "{\n       \"username\":\"admin\",\n       \"password\":\"000000\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "1",
            "description": "<p>变更行数</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "成功返回值:",
          "content": "{\n    \"id\": 1,\n    \"datalag\": 0,\n    \"versionNumber\": 0,\n    \"createdDate\": 1551836927000,\n    \"createdBy\": 0,\n    \"lastUpdatedDate\": 1551836927000,\n    \"lastUpdatedBy\": 0,\n    \"userNumber\": 865533614,\n    \"username\": \"admin\",\n    \"password\": \"1eb1f481ceaf83536f48b38d1d330e91\",\n    \"name\": \"张照威\",\n    \"age\": 24\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/zzw/usermanage/controller/UserController.java",
    "groupTitle": "用户控制器"
  }
] });
