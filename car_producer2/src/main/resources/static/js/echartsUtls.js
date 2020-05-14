/**
 * 柱状图
 * @param title
 * @param explanation
 * @param names
 * @param name
 * @param values
 */
function echartsUtils(title,explanation,names,name,values) {
    // 基于准备好的dom，初始化echarts实例
    // 显示标题，图例和空的坐标轴
    var myChart = echarts.init(document.getElementById('main'));
    myChart.setOption({
        title: {
            text: title
        },
        tooltip: {},
        legend: {
            data:explanation
        },
        xAxis: {
            data: names
        },
        yAxis: {},
        series: [{
            name: name,
            type: 'bar',
            data: values
        }]
    });
}




