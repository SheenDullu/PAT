/**
 * Created by phadkep on 9/2/2016.
 */
document.getElementById("login").style.visibility="hidden";
function signIn() {
    setVisibility();
}

function setVisibility() {

    document.getElementById("myCarousel").style.visibility="hidden";
    document.getElementById("signIn").style.visibility="hidden";
    document.getElementById("searchByManager").style.visibility="visible";
}


function callService(choice) {

    $.ajax({
        url: "file3.json",
        type: "get",
        datatype: "json",

        success: function (result) {

            var data1 = [];
            data1 = result.associate;
            var dataLength = data1.length;

            var date = [];
            var hike = [];
            var rating = [];
            var promotion = [];

            date[0] = 'Time Period';
            hike[0] = 'Percentage Hike';
            rating[0] = 'Rating Grade';
            promotion[0] = 'Promotion Scale';

            for (var i = 0; i < dataLength; i++) {

                date[i + 1] = data1[i].date;
                hike[i + 1] = data1[i].hike
                rating[i + 1] = data1[i].rating;
                promotion[i + 1] = data1[i].promotion;

            }


            switch(choice){

                case 1:
                    $("#chart1").css("display","block");
                    loadRatingScale(date,rating);
                    $("#chart2,#chart3").css("display","none");
                    break;
                case 2:
                    $("#chart2").css("display","block");
                    loadPercentageHike(date,hike);
                    $("#chart1,#chart3").css("display","none");
                    break;
                case 3:
                    $("#chart3").css("display","block");
                    loadPromotionGrade(date,promotion);
                    $("#chart1,#chart2").css("display","none");
                    break;
                case 4:
                    $("#chart1,#chart2,#chart3").css("display","block");
                    loadPromotionGrade(date,promotion);
                    loadPercentageHike(date,hike);
                    loadRatingScale(date,rating);
                    break;
            }
        },

        error: function (result) {

            console.log("Result error ");
        }

    });

}

function loadRatingScale(date, rating) {

    var chart = c3.generate({
        bindto: '#chart1',
        data: {
            x: 'Time Period',
            columns: [
                date,
                rating

            ],
            type:'bar',
            colors: {
                'Rating Grade': '#21ABCD'
            }
        },
        bar: {
            width:50
        },
        axis: {
            x: {
                type: 'timeseries',
                tick: {
                    format: '%d-%m-%Y'
                },
                label: {
                    text: 'Time Period',
                    position: 'outer-center'
                }
            },
            y: {
                min:1,
                max:5,
                tick: {
                    format: function(d) {
                        return d3.round(d);
                    },
                    values:[1,2,3,4,5]
                },
                label: {
                    text: 'Rating Scale',
                    position: 'outer-middle'
                }
            }
        },
        title: {
            font: 20,
            text: 'Rating Scale'
        }

    });

}


function loadPercentageHike(date, hike) {

    var chart = c3.generate({
        bindto: '#chart2',
        data: {
            x: 'Time Period',
            columns: [
                date,
                hike
            ],
            type:'bar',
            colors: {
                'Percentage Hike': '#21ABCD'
            }
        },
        bar: {
            width:50
        },
        axis: {
            x: {
                type: 'timeseries',
                tick: {
                    format: '%d-%m-%Y'
                },
                label: {
                    text: 'Time Period',
                    position: 'outer-center'
                }
            },
            y: {
                min:1,
                max:15,
                label: {

                    text: 'Salary Hike in Percentage',
                    position: 'outer-middle'
                }
            }
        },
        title: {
            text: 'Salary Hike'
        }

    });

}


function loadPromotionGrade(date, promotion) {

    var chart = c3.generate({

        bindto: '#chart3',
        data: {
            x: 'Time Period',

            columns: [
                date,
                promotion
            ],
            type:'area-step',
            colors: {
                'Promotion Scale': '#21ABCD'
            }

        },
        axis: {

            x: {
                type: 'timeseries',
                tick: {
                    format: '%d-%m-%Y'
                },
                label: {
                    text: 'Time Period',
                    position: 'outer-center'
                }
            },
            y: {
                label: {
                    text: 'Promotion Grade',
                    position: 'outer-middle'
                },
                min:100,
                max:700,
                tick:{
                    values:[100,200,300,400,500,600,700]
                }
            }
        },
        title: {
            text: 'Promotion Grade'
        }


    });
}

