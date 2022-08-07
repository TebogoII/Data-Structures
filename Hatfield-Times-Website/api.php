<?php
	$data = [ 'status' => 'success', 'timestamp' => time(), 'data' => ['title' => 'Rise in Oil Prices','authour' => 'James Turell','date' => date("Y-m-d",time())] ];
	header('Content-Type: application/json; charset=utf-8');
	echo json_encode($data);
?>