<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <script type="text/javascript">
    function Person() {
      this.name;
      this.age;
      this.sex;
      this.show=function () {
        console.log(this.name +":"+ this.age +":"+ this.sex)
      }
    }

    var person = new Person();
    person.name = "阿强";
    person.age = 18;
    person.sex = "男";
    person.show();

    var stu = new Object();
    stu.name = "阿秀";
    stu.age = 16;
    stu.sex = "女";
    console.log(stu.name+":"+stu.age+":"+stu.sex);

    //JSON
    var stus = {name:"阿丽", age:19, sex :"女"};
    //打印stus对象的各个属性
    console.log(stus.name + ":" +stus.age +":"+stus.sex);
    console.log(stus);

    //JSON对象转换为字符串
    var ss = JSON.stringify(stus);
    console.log("json对象转换为字符串："+ ss);

    //JSON 字符串(定义方式符合了JSON的定义方式)
    var stu = '{"name":"阿美", "age":22, "sex":"女"}';
    console.log("这是JSON字符串："+stu);

    //JSON字符串转换为JSON对象
    var s = JSON.parse(stu);
    console.log(s);

    var arr = ["北京", "上海", "广州"];
    var arr2 = [{name:"阿强", age:19}, {name:"阿秀", age:22} ,{name:"阿美", age:20} ];

    var a = JSON.stringify(arr);
    var aa = JSON.stringify(arr2);
    console.log(a);
    console.log(aa);
    console.log(arr2[0].name);

  </script>

  </body>
</html>
