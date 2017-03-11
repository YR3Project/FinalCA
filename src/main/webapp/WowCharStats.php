<?php
    $wowName = 'Aleks';
    $wowserver = 'Silvermoon';
    $apiKeyWow = 'q4t5bsyufrehzx4a98wazgax79tbhbur';
    $wowresult= file_get_contents("https://eu.api.battle.net/wow/character/" . $wowserver . "/" . $wowName . "?locale=en_GB" . "&apikey=" . $apiKeyWow);
    $wowprint = json_decode($wowresult);
    $name = $wowprint->name;
    $battlegroup = $wowprint->battlegroup;
    $level = $wowprint->level;
    $class = $wowprint->class;
    $thumbnail = $wowprint->thumbnail;
  ?>
  <?php
    print '<br>';
    print '<img src="https://render-api-eu.worldofwarcraft.com/static-render/eu/'. $thumbnail . '" height="42" width="42">';
    print '<p><b>Name = ' . $name;
    print '<p><b>Level = ' . $level;
    print '<p><b>Battlegroup = ' . $battlegroup;
    print '<p><b>Class = ' . $class;
    print '<br><br>';
  ?>