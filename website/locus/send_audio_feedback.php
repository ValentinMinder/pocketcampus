<?php

header('Content-Type: application/json');

$ret_json = array();

if(empty($_FILES["file"])) {
	die(json_encode(array("status" => "error", "message" => "no file")));
}

$allowedExts = array("wav", "mp3", "m4a");
$temp = explode(".", $_FILES["file"]["name"]);
$extension = end($temp);
//if ((($_FILES["file"]["type"] == "image/gif")
//|| ($_FILES["file"]["type"] == "image/jpeg")
//|| ($_FILES["file"]["type"] == "image/jpg")
//|| ($_FILES["file"]["type"] == "image/pjpeg")
//|| ($_FILES["file"]["type"] == "image/x-png")
//|| ($_FILES["file"]["type"] == "image/png"))
//&& ($_FILES["file"]["size"] < 2000000)
//&& in_array($extension, $allowedExts))
//  {
  if ($_FILES["file"]["error"] > 0)
    {
//    echo "Return Code: " . $_FILES["file"]["error"] . "<br>";
    die(json_encode(array("status" => "error", "message" => "error code {$_FILES["file"]["error"]}")));
    }
  else
    {
//    echo "Upload: " . $_FILES["file"]["name"] . "<br>";
//    echo "Type: " . $_FILES["file"]["type"] . "<br>";
//    echo "Size: " . ($_FILES["file"]["size"] / 1024) . " kB<br>";
//    echo "Temp file: " . $_FILES["file"]["tmp_name"] . "<br>";

//    if (file_exists("upload/" . $_FILES["file"]["name"]))
//      {
//      echo $_FILES["file"]["name"] . " already exists. ";
//      }
//    else
//      {
      $new_file = basename($_FILES["file"]["tmp_name"]) . ".$extension";
      move_uploaded_file($_FILES["file"]["tmp_name"],
      "audio/$new_file");// . $_FILES["file"]["name"]);
      die(json_encode(array("status" => "success", "message" => "Upload succeeded. Thank you for your feedback!", "filename" => "$new_file")));
      echo "$new_file";// . $_FILES["file"]["name"];
//      echo "<h2>Preview</h2> <p><iframe src=\"https://pocketcampus.epfl.ch/events/openhouse2014/images/$new_file\" style=\"width:300px;height:300px;\"></iframe></p>";
//      }
    }
//  }
//else
//  {
//  echo "Invalid file";
//  }
?>
