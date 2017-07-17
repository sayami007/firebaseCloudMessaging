<?php
		$token = $_POST['token'];
		$table = 'tokens';
		$db = "fcm";
		$con = mysqli_connect('localhost','root','',$db) or die("ERROR IN CONNECTION");
		$query = "INSERT INTO $table(token) VALUES('$token') ON DUPLICATE KEY UPDATE token = '$token';";
		$q = mysqli_query($con,$query);
		if(!$q)
			die(mysqli_error($con));
?>
