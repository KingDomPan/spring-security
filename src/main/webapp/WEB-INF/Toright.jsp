<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resource/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="resource/css/right.css">
    <script src="resource/js/jquery-1.11.1.min.js"></script>
    <script src="resource/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="resource/js/right.js"></script>
  </head>
  <body>
     <div style="float:left"><button class="btn btn-success" id="animation">dfs</button></div>
     <div class="right">
        <div class="right-top">
          <div class="right-top-context">
            <div class="head-log">
              <span class="head-log-font">itmapp1</span>
            </div>
            <div class="head-button">
               <button style="background:url('resource/image/btn-run.png')" class="btn-run" id="btn-run">运行中</button>
            </div>
            <div class="right-tool">
                <div class="all-screen tooltip-max" data-toggle="tooltip" data-placement="bottom"  title="最大化"><button style="background: url('resource/image/max.png')" class="btn-allscreen" id="ss"></button></div>
                <div class="close-screen tooltip-close" data-toggle="tooltip" data-placement="bottom"  title="关闭"><button style="background: url('resource/image/close.png')" class="close-allscreen"></button></div>
            </div>
          </div>
        </div>

        <div class="right-context">
          <div class="first-containt">
            <div class="contian-all">
              <div class="redhat-img">
                <p class="xinxi">信息</p>
                <div class="yuanxin" style="background:url('resource/image/redhat.png')"></div>
              </div>
              <div class="information">
                <br>
                <span style="color:#1f70a8;font-size:24px;">redhat</span><br>
                <span style="color:#1f70a8;font-size:13px">Enterprise Linux Server release 5.5(Tikanga)</span><br>
                <span style="color:#1f70a8;font-size:13px">Oops agent: V1.0.3_12</span><br>
                <span style="color:#b2912b;font-size:13px;font-weight:bold">1</span>
                <span style="color:#1f70a8;font-size:13px;">CPUS</span><br>
                <span style="color:#b2912b;font-size:13px;font-weight:bold">16</span>
                <span style="color:#1f70a8;font-size:13px;">GBRAM</span><br>
                <span style="color:#b2912b;font-size:13px;font-weight:bold">2</span>
                <span style="color:#1f70a8;font-size:13px;">TB Hard Disk</span><br>
                 <span style="color:#1f70a8;font-size:13px;">Intel Xeon</span><br>
              </div>
            </div>
          </div>
          <div class="dotted-line"></div>
          <div class="second-containt">
            <div class="contain-all2">
                <div class="line1">
                  <span style="color: #3d5b77;font-size: 15px;font-family: Microsoft Yahei;float:left;display:inline;position:relative;top:-158px">网元标签</span>
                  <div class="help tooltip-help" style="background: url('resource/image/help.png')" data-toggle="tooltip" data-placement="top"  title="帮助" ></div>
                  <div class="question tooltip-edite" id="edit-tag" style="background: url('resource/image/btn_edit.png')" data-toggle="modal" data-placement="top"  title="编辑"  href="#tag"></div>
                </div>
                <div class="line2" id="all-tag">
                   <div class="change-color oracle">oracle</div>
                   <div class="change-color ITSM">ITSM</div>
                </div>
            </div>
          </div>
          <div class="dotted-line"></div>
          <div  class="third-contain">
            <div class="user-product">
              <span style="color: #3d5b77;font-size: 15px;font-family: Microsoft Yahei;">可执行操作</span>
              <div class="product-all">
                <div class="contain-product move-pc"><div class="none-border cur m1" style="background: url('resource/image/btn_1.png')"></div><span class="font-user cur">Dashboard</span></div>
                <div class="contain-product move-pc2"><div class="none-border cur m2" style="background: url('resource/image/btn_2.png')"></div><span class="font-user cur">Console</span></div>
                <div class="contain-product move-pc3"><div class="none-border cur m3" style="background: url('resource/image/btn_3.png')"></div><span class="font-user cur">软件包管理</span></div>
                <div class="contain-product move-pc4"><div class="none-border cur m4" style="background: url('resource/image/btn_4.png')"></div><span class="font-user cur">电源管理</span></div>
                <div class="contain-product move-pc5"><div class="none-border cur m5" style="background: url('resource/image/btn_5.png')"></div><span class="font-user cur">链接KVM</span></div>
            </div>
          </div>
        </div>

        <div aria-hidden="true" class="modal fade" id="tag" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" data-backdrop="static">
          <div class="modal-dialog">
            <div class="modal-content modal-style">
              <div class="modal-header" style="background:#428BCB;color:#ffffff">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" id="close-tag">&times;</button>
                <h5>编辑标签</h5>
              </div>
            <form action="" role="form" class="form-horizontal">
              <div class="modal-body">
                <div class="form-group ">
                  <div class="col-sm-9 edit-tag" id="load-trage">
                   
                  </div>   
                  <div class="btn btn-success">保 存</div>           
               </div>
              </div>
              <div class="modal-footer">
                <div style="float:left">
                  <span style="float:left">建议标记</span><br>
                  <span>使用Premlum访问权限</span>
                </div>
              </div>
            </form>
            </div>
          </div>
        </div>

     </div>
  </body>
</html>