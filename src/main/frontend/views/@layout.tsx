import { effect, signal } from '@vaadin/hilla-react-signals';
import { AppLayout } from '@vaadin/react-components';
import { Suspense, useEffect } from 'react';
import { Outlet } from 'react-router-dom';

const defaultTitle = document.title;
const documentTitleSignal = signal('');
effect(() => {
    document.title = documentTitleSignal.value;
});

// Publish for Vaadin to use
(window as any).Vaadin.documentTitleSignal = documentTitleSignal;

export default function MainLayout() {

    useEffect(() => {
        documentTitleSignal.value = defaultTitle;

    }, []);

    return (
        <AppLayout>
            <Suspense>
                <Outlet />
            </Suspense>
        </AppLayout>
    );
}
