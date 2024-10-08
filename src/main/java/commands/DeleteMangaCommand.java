package commands;

import author.Author;
import author.AuthorList;
import exceptions.TantouException;
import manga.Manga;
import ui.Ui;

import static constants.Command.DELETE_COMMAND;

public class DeleteMangaCommand extends Command {
    private String userInput;

    public DeleteMangaCommand(String userInput) {
        super(DELETE_COMMAND);
        this.userInput = userInput;
    }

    /**
     * Conducts several checks on the userInput and authorList before deleting the manga from the list.
     * If any of the checks fail, a TantouException is thrown.
     */
    @Override
    public void execute(Ui ui, AuthorList authorList) throws TantouException {
        String authorName = parser.getAuthorNameFromInput(userInput);
        String mangaName = parser.getMangaNameFromInput(userInput);

        if (authorName.isEmpty() || mangaName.isEmpty()) {
            throw new TantouException("No author or manga provided!");
        }

        Author attachedAuthor = new Author(authorName);
        Manga deletingManga = new Manga(mangaName, attachedAuthor);

        if (authorList.hasAuthor(attachedAuthor)) {
            Author existingAuthor = authorList.getAuthor(attachedAuthor);
            if (existingAuthor.hasManga(deletingManga)) {
                existingAuthor.deleteManga(deletingManga);
                System.out.printf("Manga %s successfully deleted from author %s\n",
                        deletingManga.getMangaName(), existingAuthor.getAuthorName());
                return;
            }

            throw new TantouException("Manga does not exist!");
        }
    }


}


