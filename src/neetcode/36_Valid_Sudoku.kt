package neetcode

fun isValidSudoku(board: Array<CharArray>): Boolean {

    // 1) Check for Rows
    for(k in board.indices){
        val rowElements = mutableMapOf<Char, Int>()
        for(i in board[k].indices){
            val currElem = board[k][i]
            if(currElem != '.'){
                if(rowElements[currElem] != null && rowElements[currElem]!! > 0){
                    return false
                }
                else{
                    rowElements[currElem] = 1
                }
            }
        }
    }

    // 2) Check for Columns
    for(i in 0 until board[0].size){
        val columnElements = mutableMapOf<Char, Int>()
        for(k in board.indices){
            val currElem = board[k][i]

            if(currElem != '.'){
                if(columnElements[currElem] != null && columnElements[currElem]!! > 0){
                    return false
                }
                else{
                    columnElements[currElem] = 1
                }
            }
        }
    }

    // 3) Check for Quads
    for(kCount in 0.. 2){
        for(iCount in 0 .. 2){

            val quadElements = mutableMapOf<Char, Int>()
            for(k in kCount*3..kCount*3+2){
                for(i in iCount*3..iCount*3+2){
                    val currElem = board[k][i]

                    if(currElem != '.'){
                        if(quadElements[currElem] != null && quadElements[currElem]!! > 0){
                            return false
                        }
                        else{
                            quadElements[currElem] = 1
                        }
                    }
                }
            }

        }
    }

    return true
}

fun main() {

    val board = arrayOf(
        charArrayOf('5','3','.','.','7','.','.','.','.'),
        charArrayOf('6','.','.','1','9','5','.','.','.'),
        charArrayOf('.','9','8','.','.','.','.','6','.'),
        charArrayOf('8','.','.','.','6','.','.','.','3'),
        charArrayOf('4','.','.','8','.','3','.','.','1'),
        charArrayOf('7','.','.','.','2','.','.','.','6'),
        charArrayOf('.','6','.','.','.','.','2','8','.'),
        charArrayOf('.','.','.','4','1','9','.','.','5'),
        charArrayOf('.','.','.','.','8','0','.','7','9')
    )

    println(isValidSudoku(board))

    val board2 = arrayOf(
        charArrayOf('8','3','.','.','7','.','.','.','.'),
        charArrayOf('6','.','.','1','9','5','.','.','.'),
        charArrayOf('.','9','8','.','.','.','.','6','.'),
        charArrayOf('8','.','.','.','6','.','.','.','3'),
        charArrayOf('4','.','.','8','.','3','.','.','1'),
        charArrayOf('7','.','.','.','2','.','.','.','6'),
        charArrayOf('.','6','.','.','.','.','2','8','.'),
        charArrayOf('.','.','.','4','1','9','.','.','5'),
        charArrayOf('.','.','.','.','8','0','.','7','9')
    )

    println(isValidSudoku(board2))

    val board3 = arrayOf(
        charArrayOf('8','3','.','.','7','.','.','.','.'),
        charArrayOf('6','.','.','1','9','5','.','.','.'),
        charArrayOf('.','9','8','.','.','.','.','6','.'),
        charArrayOf('1','.','.','.','6','.','.','.','3'),
        charArrayOf('4','.','.','8','.','3','.','.','1'),
        charArrayOf('7','.','.','.','2','.','.','.','6'),
        charArrayOf('.','6','.','.','.','.','2','8','.'),
        charArrayOf('.','.','.','4','1','9','.','.','5'),
        charArrayOf('.','.','.','.','8','0','.','7','9')
    )

    println(isValidSudoku(board3))
}