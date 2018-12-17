<html>
<head>
    <meta charset="utf-8">
    <title>Freemarker入门小DEMO </title>
</head>
<body>
<#--我只是一个注释，我不会有任何输出  -->
<#include "head.ftl">
${name},你好。${message}<br/>

<#assign linkman="周先生">
联系人:${linkman}

<#assign info={"mobile":"1522345678","address":"北京市海淀区西北旺"}>
电话:${info.mobile},地址:${info.address}<br/>

<#if success=true>
    你已通过实名认证
<#else >
    你未通过实名认证
</#if>

<hr/>

<#list goodsList as goods>
    ${goods_index+1} 商品名称：${goods.name}, 价格：${goods.price}<br/>
</#list>

共${goodsList?size}条记录<br/>

<hr/>

<#assign text="{'bank':'工商银行','account':'10101920201920212'}" />
<#assign date=text?eval>
开户行:${date.bank} 账号:${date.account}

<hr/>

当前日期：${today?date}<br/>
当前时间：${today?time}<br/>
当前日期加时间：${today?datetime}<br/>
日期格式化：${today?string("yyyy年MM月")}<br/>

金额：${point}<br/>
金额：${point?c}

<#if num??>
    num变量存在
<#else >
    变量不存在
</#if>

</body>
</html>