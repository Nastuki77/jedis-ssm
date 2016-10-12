/**
 * Created by cxx on 2015/7/29.
 */
if(typeof (MyUtil) == 'undefined'){
    MyUtil={
        /*
         * 将json数据传给form中的input类型的对象
         * (form中:input 的 name 要和 json 的属性对应 )
         */
        transferJsonToForm:function(json,formName){
            MyUtil.clearFormValue(formName);
            for(var i in json){
               jQuery("#"+formName+" input[name='"+i+"']").val(json[i])
            }
        },
        /*
         * 清除form中input类型的对象的值
         */
        clearFormValue:function(forName){
            jQuery("#"+forName+" :input").each(
                function(){
                    var name = jQuery(this).attr("name");
                    jQuery("#"+forName+" input[name="+name+"]").val('');
                }
            );
        },
        pageByForm2:function (curPage,curPageName,formname,repsonseId) {
            var dft=0;
            if("undefined"==typeof(curPageName)||null==curPageName||curPageName==""){
                curPageName="curPage";
                dft++;
            }

            if("undefined"==typeof(formname)||null==formname||formname==""){
                formname="pageForm";
                dft++;
            }
            if(dft==2){
                repsonseId="dft";
            }

            jQuery("#"+curPageName).val(curPage);


            var prm =jQuery("#"+formname).serialize();
            var flg= "undefined"!=typeof(repsonseId) && repsonseId!=0&&repsonseId!="";

            if(flg){

                var url = jQuery("#"+formname).attr("action");
                $.ajax({
                    type : "POST",
                    url : url,
                    data : prm,
                    success : function(msg) {

                        if(repsonseId=="dft"){
                            var divId= jQuery("#divId").val();
                            var flg1= "undefined"!=typeof(divId) && divId!=0&&divId!="";
                            if(flg1){
                                jQuery("#"+divId).html(msg);
                            }else{
                                jQuery(jQuery("#"+formname)).parent()[0].html(msg);
                            }


                        }else{
                            jQuery("#"+repsonseId).html(msg);
                        }


                    }
                });
            }else{
                if(repsonseId=="dft"){
                    var url = jQuery("#"+formname+"").attr("action");
                    $.ajax({
                        type : "POST",
                        url : url,
                        data : prm,
                        success : function(msg) {
                            var divId= jQuery("#divId").val();

                            var flg= "undefined"!=typeof(divId) && divId!=0&&divId!="";
                            if(flg){
                                jQuery("#"+divId).html(msg);
                            }else{
                                jQuery(jQuery("#"+formname)).parent()[0].html(msg);
                            }

                        }
                    });
                }else{
                    $("#"+formname+"").submit();
                }
            }
        }
    }
}