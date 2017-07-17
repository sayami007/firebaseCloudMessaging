<?php
$table = 'tokens';
$db = 'fcm';


  function send_notification($tokens,$message){
    $url = 'https://fcm.googleapis.com/fcm/send';
    $fields = array(
        'registration_ids'=>$tokens,
        'data'=>$message
    );
    $header = array(
      'Authorization:key=AAAASRyrPfM:APA91bFQdUJRYkNMrppep1jQFmr_sz5A3XpTL7rFL8pJ5gJ4l7ETYE5BTPZV9jnkBouFRg5giQ17qQZy8SYTgKvSC0403Is31SQowhyYkr4i6ZCvUR5CdGPvh111UXLhvWidrllaF1SH',
      'Content-Type:application/json'
    );
    $ch = curl_init();
    curl_setopt($ch,CURLOPT_URL,$url);
    curl_setopt($ch,CURLOPT_POST,true);
    curl_setopt($ch,CURLOPT_HTTPHEADER,$header);
    curl_setopt($ch,CURLOPT_RETURNTRANSFER,true);
    curl_setopt($ch,CURLOPT_SSL_VERIFYHOST,0);
    curl_setopt($ch,CURLOPT_SSL_VERIFYPEER,false);
    curl_setopt($ch,CURLOPT_POSTFIELDS,json_encode($fields));
    $result = curl_exec($ch);
    if($result === FALSE)
      die('CURL Failed: '.curl_error($ch));
    curl_close($ch);
    return $result;
  }

  $conn = mysqli_connect('localhost','root','',$db);
  $query = "SELECT token FROM $table";
  $result = mysqli_query($conn,$query) or die('error');

  $tokens = array();
  if(mysqli_num_rows($result) > 0):
    while($row = mysqli_fetch_assoc($result)){
      $tokens[]=$row['token'];
    }
  endif;
  mysqli_close($conn);

  $message = array("message"=>"TEST SUCCESSFUL",
                  "body"=>"HELLOW WORLD",
                  "name"=>"BIBESH");
  $message_status = send_notification($tokens,$message);
  echo $message_status;

 ?>
