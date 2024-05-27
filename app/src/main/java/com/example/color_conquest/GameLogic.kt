package com.example.color_conquest

import androidx.compose.ui.graphics.Color

fun createTile(n: Int){
    for (i in 0..<n){
        tile.add(0)
    }
}

fun createBelongsTO(n: Int){
    for (i in 0..<n){
        belongsTo.add(0)
    }
}

fun topEdge(n: Int): MutableList<Int>{
    var l: MutableList<Int> = mutableListOf(0)
    l.removeAt(0)
    for (i in 1..(n-2)){
        l.add(i)
    }
    return l
}

fun leftEdge(n: Int): MutableList<Int>{
    var l: MutableList<Int> = mutableListOf(0)
    l.removeAt(0)
    for (i in 1..(n-2)){
        l.add(n*i)
    }
    return l
}

fun rightEdge(n: Int): MutableList<Int>{
    var l: MutableList<Int> = mutableListOf(0)
    l.removeAt(0)
    for (i in 1..(n-2)){
        l.add((n*i) + (n-1))
    }
    return l
}

fun bottomEdge(n: Int): MutableList<Int>{
    var l: MutableList<Int> = mutableListOf(0)
    l.removeAt(0)
    for (i in ((n*n)-(n+1))..<(n*n)){
        l.add(i)
    }
    return l
}

fun modifyTile(n: Int){
    if (tile.contains(4)){
        if (listOf(0, n-1, (n*n)-1, (n*n)-n).contains(tile.indexOf(4))){
            var temp = tile.indexOf(4)
            if (tile.indexOf(4) == 0){
                tile[temp] = 0
                tile[temp + 1] += 1
                tile[temp + n] += 1
                belongsTo[temp + 1] = belongsTo[temp]
                belongsTo[temp + n] = belongsTo[temp]
                belongsTo[temp] = 0
            }
            else if (tile.indexOf(4) == n-1){
                tile[temp] = 0
                tile[temp - 1] += 1
                tile[temp + n] += 1
                belongsTo[temp - 1] = belongsTo[temp]
                belongsTo[temp + n] = belongsTo[temp]
                belongsTo[temp] = 0
            }
            else if (tile.indexOf(4) == (n*n)-n){
                tile[temp] = 0
                tile[temp + 1] += 1
                tile[temp - n] += 1
                belongsTo[temp + 1] = belongsTo[temp]
                belongsTo[temp - n] = belongsTo[temp]
                belongsTo[temp] = 0
            }
            else if (tile.indexOf(4) == (n*n)-1){
                tile[temp] = 0
                tile[temp - 1] += 1
                tile[temp - n] += 1
                belongsTo[temp - 1] = belongsTo[temp]
                belongsTo[temp - n] = belongsTo[temp]
                belongsTo[temp] = 0
            }
        }

        else if((topEdge(n) + leftEdge(n) + rightEdge(n) + bottomEdge(n)).contains(tile.indexOf(4))){
            var temp = tile.indexOf(4)
            if (leftEdge(n).contains(tile.indexOf(4))){
                tile[temp] = 0
                tile[temp + 1] += 1
                tile[temp + n] += 1
                tile[temp - n] += 1
                belongsTo[temp + 1] = belongsTo[temp]
                belongsTo[temp + n] = belongsTo[temp]
                belongsTo[temp - n] = belongsTo[temp]
                belongsTo[temp] = 0
            }
            else if (rightEdge(n).contains(tile.indexOf(4))){
                tile[temp] = 0
                tile[temp - 1] += 1
                tile[temp + n] += 1
                tile[temp - n] += 1
                belongsTo[temp - 1] = belongsTo[temp]
                belongsTo[temp + n] = belongsTo[temp]
                belongsTo[temp - n] = belongsTo[temp]
                belongsTo[temp] = 0
            }
            else if (topEdge(n).contains(tile.indexOf(4))){
                tile[temp] = 0
                tile[temp - 1] += 1
                tile[temp + 1] += 1
                tile[temp + n] += 1
                belongsTo[temp - 1] = belongsTo[temp]
                belongsTo[temp + 1] = belongsTo[temp]
                belongsTo[temp + n] = belongsTo[temp]
                belongsTo[temp] = 0
            }
            else if (bottomEdge(n).contains(tile.indexOf(4))){
                tile[temp] = 0
                tile[temp - 1] += 1
                tile[temp + 1] += 1
                tile[temp - n] += 1
                belongsTo[temp - 1] = belongsTo[temp]
                belongsTo[temp + 1] = belongsTo[temp]
                belongsTo[temp - n] = belongsTo[temp]
                belongsTo[temp] = 0
            }
        }

        else{
            var temp = tile.indexOf(4)
            tile[temp] = 0
            tile[temp - 1] += 1
            tile[temp + 1] += 1
            tile[temp - n] += 1
            tile[temp + n] += 1
            belongsTo[temp + 1] = belongsTo[temp]
            belongsTo[temp + n] = belongsTo[temp]
            belongsTo[temp - 1] = belongsTo[temp]
            belongsTo[temp - n] = belongsTo[temp]
            belongsTo[temp] = 0
        }
        return modifyTile(n)
    }
    else{
        playerOnePoints.intValue = 0
        playerTwoPoints.intValue = 0
        for (i in 0..24){
            if (belongsTo[i] == 1){
                playerOnePoints.intValue += tile[i]
            }
            else if (belongsTo[i] == 2){
                playerTwoPoints.intValue += tile[i]
            }
        }
        return
    }
}

fun reset(){
    currentPlayerNumber.intValue = 1
    currentColor.value = Color(0xffff5f57)
    for (i in 0..24){
        tile[i] = 0
        belongsTo[i] = 0
    }
    playerOneFirstTurn.intValue = 1
    playerTwoFirstTurn.intValue = 1
    colorBit.intValue = 0
    currentPlayer.value = playerOne.value
    playerOnePoints.intValue = 0
    playerTwoPoints.intValue = 0
    grantedTo.intValue = 0
}

fun updateScoreBoard(pm: PreferencesManager, player: String){
    var keys: MutableSet<String> = pm.getAllKeys()
    if (player in keys){
        var wins = pm.getData(player, 0)
        pm.saveData(player, wins+1)
    }
    else{
        pm.saveData(player, 1)
    }
}