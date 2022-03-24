import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ScrabblePresenterTest {

    private ScrabbleFrame view = Mockito.mock(ScrabbleFrame.class);
    private ScrabbleGame model = Mockito.mock(ScrabbleGame.class);
    private ScrabblePresenter presenter = new ScrabblePresenter(view, model);
    private List<Character> tiles = new ArrayList<>();

    @Test
    public void fillTiles() {
        //given
        doReturn(tiles).when(model).getTiles();

        //when
        presenter.fillTiles();

        //then
        verify(model).getTiles();
        verify(view).setTiles(tiles);
    }

    @Test
    public void playWord_true(){
        //given
        doReturn(tiles).when(model).getTiles();
        doReturn(true).when(model).playWord("HELLO");

        //when
        presenter.playWord("HELLO");

        //then
        verify(model).playWord("HELLO");
        verify(view).setScore("1");
        verify(model).getTiles();
        verify(view).setTiles(tiles);


    }

    @Test
    public void playWord_false(){
        //given
        doReturn(tiles).when(model).getTiles();
        doReturn(false).when(model).playWord("HEL");

        //when
        presenter.playWord("HEL");

        //then
        verify(model).playWord("HEL");
        //verify(view).setErrorMessage("Wrong Word");


    }

}