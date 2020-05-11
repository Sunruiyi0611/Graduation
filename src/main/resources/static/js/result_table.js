function showTable(results){
    var str = "";
    var pSum=0;
    var bSum=0;
    var cSum=0;
    var eSum=0;
    str += "<div class=\"table-responsive\">" +
        "<table class=\"table table-striped table-sm\">" +
        "<thead>";

    str +="<tr>" +
        "<th>具体时间</th>" +
        "<th>人数</th>" +
        "<th>自行车数</th>" +
        "<th>汽车数</th>" +
        "<th>电动车数</th>" +
        "</tr>" +
        "</thead>" +
        "<tbody>";
    //遍历数据
    $.each(results, function (index, item){
        str +="<tr><td>"+item.specific_time+" : 00</td><td>"+item.people_amount+"</td><td>"+item.bike_amount+"</td><td>"
            +item.car_amount+"</td><td>"+item.electrombile_amount+"</td></tr>";
        pSum+=item.people_amount;
        bSum+=item.bike_amount;
        cSum+=item.car_amount;
        eSum+=item.electrombile_amount;
    });
    str+="<tr><td>合计</td><td>"+pSum+"</td><td>"+bSum+"</td><td>" +cSum+"</td><td>"+eSum+"</td></tr>";
    //遍历完成之后
    str +="</tbody></table></div>";
    //将表格添加到body中
    $('[role="main"]').append(str);

}

function showTableWithDir(results){
    var str = "";
    var pSum = 0;
    var bSum = 0;
    var cSum = 0;
    var eSum = 0;
    str += "<div class=\"table-responsive\"> " +
        "<table class=\"table table-striped table-sm\">" +
        "<thead>";

    str +="<tr>" +
        "<th>具体时间</th>" +
        "<th>人数</th>" +
        "<th>自行车数</th>" +
        "<th>汽车数</th>" +
        "<th>电动车数</th>" +
        "<th>方向</th>" +
        "</tr>" +
        "</thead>" +
        "<tbody>";
    //遍历数据
    $.each(results, function (index, item){
        str +="<tr><td>"+item.specific_time+" : 00</td><td>"+item.people_amount+"</td><td>"+item.bike_amount+"</td><td>"
            +item.car_amount+"</td><td>"+item.electrombile_amount+"</td><td>"+item.direction+"</td></tr>";
        pSum+=item.people_amount;
        bSum+=item.bike_amount;
        cSum+=item.car_amount;
        eSum+=item.electrombile_amount;
    });
    str+="<tr><td>合计</td><td>"+pSum+"</td><td>"+bSum+"</td><td>" +cSum+"</td><td>"+eSum+"</td></tr>";
    //遍历完成之后
    str +="</tbody></table></div>";
    //将表格添加到body中
    $('[role="main"]').append(str);

}
