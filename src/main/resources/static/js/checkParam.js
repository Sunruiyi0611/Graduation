
function checkLoc() {
    if (form1.loc.value=="")
    {
        alert("“地点”不能为空");
        //form1.loc.focus();
        return false;
    }

}

function checkTime() {
    if (form1.tim.value=="")
    {
        alert("“时间”不能为空");
        //form1.loc.focus();
        return false;
    }

}

function checkStart() {
    if (form1.start.value=="")
    {
        alert("“开始时间”不能为空");
        //form1.loc.focus();
        return false;
    }

    if (Math.floor(form1.start.value) != form1.start.value) {
        alert("“开始时间”应为整数");
        return false;
    }


    if (form1.start.value<0 || form1.start.value>24) {
        alert("“开始时间”无效");
        return false;
    }

}

function checkEnd() {
    if (form1.end.value=="")
    {
        alert("“结束时间”不能为空");
        //form1.loc.focus();
        return false;
    }

    if (form1.end.value < form1.start.value) {
        alert("“结束时间”应不小于“开始时间”");
        //form1.loc.focus();
        return false;
    }
    if (Math.floor(form1.end.value) != form1.end.value) {
        alert("“结束时间”应为整数");
        return false;
    }

    if (form1.end.value<0 || form1.end.value>24) {
        alert("“结束时间”无效");
        return false;
    }

}