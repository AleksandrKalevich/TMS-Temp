package com.github.krottv.tmstemp.data.remoteimport com.github.krottv.tmstemp.domain.*class SongRemoteDataSourceFake : SongRemoteDataSource {    override suspend fun getSongs(albumType: AlbumType): SongsJSON {        return when(albumType.contentType) {            ContentType.ITUNES -> getItunesSongs(albumType.albumId)            ContentType.LIBRARY -> getLibrarySongs(albumType.albumId)            else -> { throw IllegalAccessError("ContentType Mismatch") }        }    }    private fun getItunesSongs(albumId: Long): SongsJSON {        val album = AlbumModel(            albumId,            "https://sun9-north.userapi.com/sun9-81/s/v1/ig2/wIL_XF8XNjbnczI7IwIec_w6FmZOxXPJLGrtMVEH7OnXTUqOpY2t_2Qt4wgHBECL8CipxHTG7bxwC35GPpsSMakE.jpg?size=1080x1054&quality=96&type=album",            "Album",            20        )        val tracks = SongModel(            "Various Artist",            "https://images.squarespace-cdn.com/content/v1/583863c1e6f2e1216884123c/1551725307246-QOUZ9YQHC83JGDQ7R9OU/R-153749-1185134135.jpeg.jpg",            "Song",            "https://dl2.mp3party.net/online/10086562.mp3"        )        val mutableListOf = ArrayList<SongModel>(20)        for (i in 0..20) {            mutableListOf.add(tracks.copy(title = "Song ${i+1}", artist = "Various Artist $albumId"))        }        return SongsJSON(album, mutableListOf)    }    private fun getLibrarySongs(albumId: Long): SongsJSON {        val album = AlbumModel(            albumId,            "https://upload.wikimedia.org/wikipedia/ru/thumb/1/1e/N.W.A.StraightOuttaCompton.jpg/274px-N.W.A.StraightOuttaCompton.jpg",            "Album",            20        )        val tracks = SongModel(            "Various Artist",            "https://upload.wikimedia.org/wikipedia/ru/thumb/1/1e/N.W.A.StraightOuttaCompton.jpg/274px-N.W.A.StraightOuttaCompton.jpg",            "Song",            "https://d1.mp3src.com/mp3/833cfa3eeb023b58f673c7be4a006a76.mp3"        )        val mutableListOf = ArrayList<SongModel>(20)        for (i in 0..20) {            mutableListOf.add(tracks.copy(title = "Song ${i+1}", artist = "Various Artist $albumId"))        }        return SongsJSON(album, mutableListOf)    }}